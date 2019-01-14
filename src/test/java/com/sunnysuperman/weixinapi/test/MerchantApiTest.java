package com.sunnysuperman.weixinapi.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunnysuperman.commons.util.FileUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.merchant.WeixinMerchantApi;
import com.sunnysuperman.weixinapi.merchant.protocol.QueryOrderRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.QueryOrderResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.RefundRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.RefundResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.SendRedpackRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.SendRedpackResponse;
import com.sunnysuperman.weixinapi.merchant.protocol.UnifiedOrderRequest;
import com.sunnysuperman.weixinapi.merchant.protocol.UnifiedOrderResponse;
import com.sunnysuperman.weixinapi.test.KeyStoreSerializer.ContextAwareKeyStore;

public class MerchantApiTest extends BaseTest {
    private WeixinMerchantApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String mchId = getString("merchant.id");
        ContextAwareKeyStore store = KeyStoreSerializer
                .deserialize(FileUtil.readAsByteArray(getResourceAsStream("security/wxpay_" + mchId + ".cert")));
        api = new WeixinMerchantApi(mchId, store.getContext().get("key").toString(), store.getKeystore(), null);
    }

    public void test_queryOrder() throws Exception {
        QueryOrderRequest req = new QueryOrderRequest();
        req.setAppid(getString("merchant.appid"));
        req.setOut_trade_no(getString("merchant.out_trade_no"));
        QueryOrderResponse response = api.queryOrder(req);
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_sendRedpack() throws Exception {
        SendRedpackRequest req = new SendRedpackRequest();
        req.setWxappid(getString("merchant.appid"));
        req.setAct_name("红包");
        req.setRemark(req.getAct_name());
        req.setClient_ip("127.0.0.1");
        req.setMch_billno("test100000");
        req.setRe_openid(getString("merchant.openid"));
        req.setScene_id("PRODUCT_5");
        req.setSend_name("我是光明大使");
        req.setWishing("你的提现到账了");
        req.setTotal_amount(100);
        SendRedpackResponse response = api.sendRedpack(req);
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_unifiedorder() throws Exception {
        String expireAsString = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date(System.currentTimeMillis() + 30L * 60 * 1000));
        UnifiedOrderRequest req = new UnifiedOrderRequest();
        req.setAppid(getString("merchant.appid"));
        req.setBody("Test h5 pay");
        req.setOut_trade_no(getString("merchant.out_trade_no"));
        req.setTotal_fee(1);
        req.setSpbill_create_ip("127.0.0.1");
        req.setNotify_url("http://localhost/1");
        req.setTrade_type("MWEB");
        req.setTime_expire(expireAsString);
        UnifiedOrderResponse response = api.unifiedorder(req);
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_refund() throws Exception {
        RefundRequest req = new RefundRequest();
        req.setAppid(getString("merchant.appid"));
        req.setOut_refund_no("");
        req.setOut_trade_no("");
        req.setTotal_fee(1);
        req.setRefund_fee(1);
        req.setOp_user_id("system");
        req.setRefund_desc("卖完了");
        RefundResponse response = api.refund(req);
        System.out.println(JSONUtil.toJSONString(response));
    }

}
