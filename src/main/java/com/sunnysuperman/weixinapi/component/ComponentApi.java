package com.sunnysuperman.weixinapi.component;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.WeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.prototype.WXBizMsgCrypt;
import com.sunnysuperman.weixinapi.user.GetAccessTokenResponse;
import com.sunnysuperman.weixinapi.user.GetUserInfoResponse;

public class ComponentApi extends WeixinApi {
    private WeixinApp app;

    public ComponentApi(WeixinApp app) {
        super(app);
        if (app.getAppType() != WeixinAppType.comp) {
            throw new RuntimeException("Not a component weixin app");
        }
    }

    public String decryptVerifyTicket(String postData, String signature, String timestamp, String nonce) {
        try {
            WXBizMsgCrypt crypt = new WXBizMsgCrypt(app.getAppToken(), app.getAppAesKey(), app.getAppId());
            String xml = crypt.decryptMsg(signature, timestamp, nonce, postData);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);
            Element root = document.getDocumentElement();
            String ticket = root.getElementsByTagName("ComponentVerifyTicket").item(0).getTextContent();
            return ticket;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public String getUserAuthorizeUrl(String appId, String redirectUrl) {
        StringBuilder buf;
        try {
            buf = new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?appid=").append(appId)
                    .append("&redirect_uri=").append(URLEncoder.encode(redirectUrl, StringUtil.UTF8))
                    .append("&response_type=code&scope=snsapi_userinfo&state=&component_appid=").append(app.getAppId())
                    .append("#wechat_redirect");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return buf.toString();
    }

    public GetAccessTokenResponse getUserAccessToken(String appId, String code, String componentAccessToken)
            throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", appId);
        params.put("code", code);
        params.put("component_appid", app.getAppId());
        params.put("component_access_token", componentAccessToken);
        params.put("grant_type", "authorization_code");
        return get("sns/oauth2/component/access_token", params, new GetAccessTokenResponse());
    }

    public GetUserInfoResponse getUserInfo(String openid, String accessToken) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("openid", openid);
        params.put("access_token", accessToken);
        return get("sns/userinfo", params, new GetUserInfoResponse());
    }

    // public void getOpenPlatformBindState(String appId, String
    // authorizerAccessToken) throws WeixinApiException {
    // Map<String, Object> params = new HashMap<>();
    // params.put("appid", appId);
    // String body = api("cgi-bin/open/get?access_token=" +
    // authorizerAccessToken, params);
    // System.out.println(body);
    // }
    //
    // public void createOpenPlatform(String appId, String
    // authorizerAccessToken) throws WeixinApiException {
    // Map<String, Object> params = new HashMap<>();
    // params.put("appid", appId);
    // String body = api("cgi-bin/open/create?access_token=" +
    // authorizerAccessToken, params);
    // System.out.println(body);
    // }
    //
    // public void bindOpenPlatform(String appId, String openAppId, String
    // authorizerAccessToken)
    // throws WeixinApiException {
    // Map<String, Object> params = new HashMap<>();
    // params.put("appid", appId);
    // params.put("open_appid", openAppId);
    // String body = api("cgi-bin/open/bind?access_token=" +
    // authorizerAccessToken, params);
    // System.out.println(body);
    // }
    //
    // public void unbindOpenPlatform(String appId, String openAppId, String
    // authorizerAccessToken)
    // throws WeixinApiException {
    // Map<String, Object> params = new HashMap<>();
    // params.put("appid", appId);
    // params.put("open_appid", openAppId);
    // String body = api("cgi-bin/open/unbind?access_token=" +
    // authorizerAccessToken, params);
    // System.out.println(body);
    // }
}
