package com.sunnysuperman.weixinapi.merchant;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.FileUtil;
import com.sunnysuperman.weixinapi.merchant.protocol.GetRedpackRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.GetRedpackResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.GetTransferInfoRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.GetTransferInfoResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.PayApiRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.PayApiResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.PayNotifyResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.QueryOrderRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.QueryOrderResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.RefundQueryRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.RefundQueryResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.RefundRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.RefundResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.SendRedpackRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.SendRedpackResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.TransferRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.TransferResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.UnifiedOrderRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.UnifiedOrderResponse;
import com.sunnysuperman.weixinapi.util.WeixinSignature;
import com.sunnysuperman.weixinapi.util.XMLParser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WeixinMerchantApi {
    private static final Logger LOG = LoggerFactory.getLogger(WeixinMerchantApi.class);
    private static final String SUCCESS_XML = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    private String mchId;
    private String key;
    private OkHttpClient httpClient;
    private boolean hasCert;

    public WeixinMerchantApi(String mchId, String key, byte[] cert, String password) {
        super();
        this.mchId = mchId;
        this.key = key;
        this.httpClient = buildHttpClient(cert, password == null ? mchId : password);
        this.hasCert = cert != null;
    }

    public String getMchId() {
        return mchId;
    }

    public String getKey() {
        return key;
    }

    public boolean isHasCert() {
        return hasCert;
    }

    private OkHttpClient buildHttpClient(byte[] cert, String certPassword) {
        InputStream certInput = null;
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory
                    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
            if (cert != null) {
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                certInput = new ByteArrayInputStream(cert);
                keyStore.load(certInput, certPassword.toCharArray());
                keyManagerFactory.init(keyStore, certPassword.toCharArray());
            } else {
                keyManagerFactory.init(null, null);
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException(
                        "[WeixinMerchantApi] Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[] { trustManager }, null);
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient httpClient = new OkHttpClient.Builder().sslSocketFactory(sslSocketFactory, trustManager)
                    .connectTimeout(10, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build();
            return httpClient;
        } catch (Exception e) {
            throw new RuntimeException(
                    "[WeixinMerchantApi] Failed to create " + WeixinMerchantApi.class.getSimpleName() + "'s HttpClient",
                    e);
        } finally {
            FileUtil.close(certInput);
        }
    }

    private <T extends PayApiResponse> T doPost(String url, PayApiRequest request, T response)
            throws WeixinMerchantException {
        if (request instanceof TransferRequest) {
            request.setMch_id(null);
            ((TransferRequest) request).setMchid(mchId);
        } else {
            request.setMch_id(mchId);
        }
        request.setSign(WeixinSignature.getSign(Bean.toMap(request), key));
        String requestAsXml = XMLParser.toXML(request);

        MediaType contentType = MediaType.parse("text/xml; charset=UTF-8");
        RequestBody requesBody = RequestBody.create(contentType, requestAsXml);
        Request req = new Request.Builder().url(url).post(requesBody).build();
        String responseAsXml;
        Response res = null;
        try {
            res = httpClient.newCall(req).execute();
            if (!res.isSuccessful()) {
                throw new WeixinMerchantException("[WeixinMerchantApi] network error: " + url);
            }
            responseAsXml = res.body().string();
        } catch (IOException e) {
            throw new WeixinMerchantException("[WeixinMerchantApi] network error: " + url);
        } finally {
            FileUtil.close(res);
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("[WeixinMerchantApi] Call <" + url + ">, Request <" + requestAsXml + "> Response: "
                    + responseAsXml);
        }
        Map<String, Object> responseAsMap;
        try {
            responseAsMap = XMLParser.getMapFromXML(responseAsXml);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new WeixinMerchantException(e);
        }
        Bean.fromMap(responseAsMap, response);
        if (!response.rawSuccess()) {
            throw new WeixinMerchantException("[WeixinMerchantApi] Bad response of api: " + url + ", " + responseAsXml);
        }
        return response;
    }

    public UnifiedOrderResponse unifiedorder(UnifiedOrderRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/pay/unifiedorder", req, new UnifiedOrderResponse());
    }

    public RefundResponse refund(RefundRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/secapi/pay/refund", req, new RefundResponse());
    }

    public RefundQueryResponse refundQuery(RefundQueryRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/pay/refundquery", req, new RefundQueryResponse());
    }

    public SendRedpackResponse sendRedpack(SendRedpackRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack", req, new SendRedpackResponse());
    }

    public GetRedpackResponse getRedpackInfo(GetRedpackRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo", req, new GetRedpackResponse());
    }

    public TransferResponse transfer(TransferRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers", req,
                new TransferResponse());
    }

    public GetTransferInfoResponse getTransferInfo(GetTransferInfoRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo", req,
                new GetTransferInfoResponse());
    }

    public QueryOrderResponse queryOrder(QueryOrderRequest req) throws WeixinMerchantException {
        return doPost("https://api.mch.weixin.qq.com/pay/orderquery", req, new QueryOrderResponse());
    }

    public static String successResponseAsXml() {
        return SUCCESS_XML;
    }

    public static PayNotifyResponse parsePayNotifyResponse(String responseAsXml, WeixinMerchantFinder merchantFinder)
            throws WeixinMerchantException {
        Map<String, Object> responseAsMap;
        try {
            responseAsMap = XMLParser.getMapFromXML(responseAsXml);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new WeixinMerchantException("[WeixinMerchantApi] Bad response: " + responseAsXml);
        }
        PayNotifyResponse notify = Bean.fromMap(responseAsMap, new PayNotifyResponse());
        if (!notify.rawSuccess()) {
            throw new WeixinMerchantException("[WeixinMerchantApi] Bad response: " + responseAsXml);
        }
        String key = merchantFinder.findMerchantKey(notify.getAppid(), notify.getMch_id());
        boolean ok = WeixinSignature.checkSign(responseAsMap, key);
        if (!ok) {
            throw new WeixinMerchantException("[WeixinMerchantApi] Bad signature: " + responseAsXml);
        }
        return notify;
    }

}
