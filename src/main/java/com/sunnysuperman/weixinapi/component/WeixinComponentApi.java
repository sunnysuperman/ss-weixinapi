package com.sunnysuperman.weixinapi.component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.WeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.crypto.WXBizMsgCrypt;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.util.XMLParser;

public class WeixinComponentApi extends WeixinApi {

    public WeixinComponentApi(WeixinApp app, HttpClientFactory httpClientFactory) {
        super(app, httpClientFactory);
        if (app.getAppType() != WeixinAppType.comp) {
            throw new RuntimeException("Not a component weixin app");
        }
    }

    public WeixinComponentApi(WeixinApp app) {
        this(app, null);
    }

    public static boolean isTokenError(int errcode) {
        // see
        // https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Global_Return_Code.html
        return errcode == 40001 || errcode == 42001;
    }

    public Map<String, Object> decryptMessage(String postData, String signature, String timestamp, String nonce) {
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(app.getAppToken(), app.getAppAesKey(), app.getAppId());
            String xml = crypt.decryptMsg(signature, timestamp, nonce, postData);
            return XMLParser.getMapFromXML(xml);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String encryptMsg(String postData, String timestamp, String nonce) {
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(app.getAppToken(), app.getAppAesKey(), app.getAppId());
            String xml = crypt.encryptMsg(postData, timestamp, nonce);
            return xml;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decryptVerifyTicket(String postData, String signature, String timestamp, String nonce) {
        Map<String, Object> data = decryptMessage(postData, signature, timestamp, nonce);
        return data.get("ComponentVerifyTicket").toString();
    }

    public GetComponentAccessTokenResponse getComponentAccessToken(String verifyTicket) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("component_appid", app.getAppId());
        params.put("component_appsecret", app.getAppSecret());
        params.put("component_verify_ticket", verifyTicket);
        return postJSON("cgi-bin/component/api_component_token", params, new GetComponentAccessTokenResponse());
    }

    public CreatePreAuthCodeResponse createPreAuthCode(String componentAccessToken) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("component_appid", app.getAppId());
        return postJSON("cgi-bin/component/api_create_preauthcode?component_access_token=" + componentAccessToken,
                params, new CreatePreAuthCodeResponse());
    }

    public String getComponentLoginUrl(String preAuthCode, String redirectUrl, int authType) {
        StringBuilder buf;
        try {
            buf = new StringBuilder("https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=")
                    .append(app.getAppId()).append("&pre_auth_code=").append(preAuthCode).append("&redirect_uri=")
                    .append(URLEncoder.encode(redirectUrl, StringUtil.UTF8)).append("&auth_type=").append(authType);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return buf.toString();
    }

    public QueryAuthResponse queryAuth(String componentAccessToken, String authCode) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("component_appid", app.getAppId());
        params.put("authorization_code", authCode);
        return postJSON("cgi-bin/component/api_query_auth?component_access_token=" + componentAccessToken, params,
                new QueryAuthResponse());
    }

    public AuthorizerToken getAuthorizerToken(String componentAccessToken, String authorizerAppid,
            String authorizerRefreshToken) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("component_appid", app.getAppId());
        params.put("authorizer_appid", authorizerAppid);
        params.put("authorizer_refresh_token", authorizerRefreshToken);
        return postJSON("cgi-bin/component/api_authorizer_token?component_access_token=" + componentAccessToken, params,
                new AuthorizerToken());
    }

    public AuthorizerInfoResponse getAuthorizerInfo(String componentAccessToken, String authorizerAppid)
            throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("component_appid", app.getAppId());
        params.put("authorizer_appid", authorizerAppid);
        return postJSON("cgi-bin/component/api_get_authorizer_info?component_access_token=" + componentAccessToken,
                params, new AuthorizerInfoResponse(), true);
    }

    public Map<String, Object> decrypt(String postData, String signature, String timestamp, String nonce) {
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(this.app.getAppToken(), this.app.getAppAesKey(),
                    this.app.getAppId());
            String xml = crypt.decryptMsg(signature, timestamp, nonce, postData);
            return XMLParser.getMapFromXML(xml, 2);
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

    public WxshopPayNotifyResponse decryptWxshopPayment(String postData, String signature, String timestamp,
                                                        String nonce) {
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(this.app.getAppToken(), this.app.getAppAesKey(),
                    this.app.getAppId());
            String xml = crypt.decryptMsg(signature, timestamp, nonce, postData);
            Map<String, Object> map = XMLParser.getMapFromXML(xml, 2);
            return Bean.fromMap(map, new WxshopPayNotifyResponse());
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

    public WxshopAftersaleResponse decryptAftersale(String postData, String signature, String timestamp, String nonce) {
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(this.app.getAppToken(), this.app.getAppAesKey(),
                    this.app.getAppId());
            String xml = crypt.decryptMsg(signature, timestamp, nonce, postData);
            Map<String, Object> map = XMLParser.getMapFromXML(xml, 2);
            return Bean.fromMap(map, new WxshopAftersaleResponse());
        } catch (Exception var7) {
            throw new RuntimeException(var7);
        }
    }

}
