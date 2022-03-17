package com.sunnysuperman.weixinapi.wework;

import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeworkSuitApi extends TokenAwareWeworkApi {

    public WeworkSuitApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public WeworkSuitApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
        if (app.getAppType() != WeixinAppType.work_app) {
            throw new RuntimeException("Not a wework app");
        }
    }

    public GetAccessTokenResponse getAccessToken(String ticket) throws WeixinApiException {
        return postJSON("/cgi-bin/service/get_suite_token", new GetAccessTokenRequest(app, ticket),
                new GetAccessTokenResponse());
    }

    public GetPreAuthCodeResponse getPreAuthCode() throws WeixinApiException {
        String accessToken = ensureAccessToken();
        return get("/cgi-bin/service/get_pre_auth_code?suite_access_token=" + accessToken, null,
                new GetPreAuthCodeResponse());
    }

    public GetPermanentCodeResponse getPermanentCode(String preAuthCode) throws WeixinApiException {
        String accessToken = ensureAccessToken();
        Map<String, Object> map = new HashMap<>(1);
        map.put("auth_code", preAuthCode);
        return postJSON("/cgi-bin/service/get_permanent_code?suite_access_token=" + accessToken, map,
                new GetPermanentCodeResponse());
    }

    public void setSessionInfoForTest(String preAuthCode) throws WeixinApiException {
        String accessToken = ensureAccessToken();
        Map<String, Object> map = new HashMap<>(2);
        map.put("pre_auth_code", preAuthCode);
        map.put("session_info", Collections.singletonMap("auth_type", 1));
        postJSON("/cgi-bin/service/set_session_info?suite_access_token=" + accessToken, map, new BaseResponse());
    }

    public String getPreAuthUrlForTest(String redirectUri) throws Exception {
        String appId = app.getAppId();
        GetPreAuthCodeResponse res = getPreAuthCode();
        String preAuthCode = res.getPre_auth_code();
        setSessionInfoForTest(preAuthCode);
        return "https://open.work.weixin.qq.com/3rdapp/install?suite_id=" + appId + "&pre_auth_code=" + preAuthCode
                + "&redirect_uri=" + redirectUri;
    }

    public void setSessionInfo(String preAuthCode) throws WeixinApiException {
        String accessToken = ensureAccessToken();
        Map<String, Object> map = new HashMap<>(2);
        map.put("pre_auth_code", preAuthCode);
        map.put("session_info", Collections.singletonMap("auth_type", 0));
        postJSON("/cgi-bin/service/set_session_info?suite_access_token=" + accessToken, map, new BaseResponse());
    }

    public String getPreAuthUrl(String redirectUri) throws Exception {
        String appId = app.getAppId();
        GetPreAuthCodeResponse res = getPreAuthCode();
        String preAuthCode = res.getPre_auth_code();
        setSessionInfo(preAuthCode);
        return "https://open.work.weixin.qq.com/3rdapp/install?suite_id=" + appId + "&pre_auth_code=" + preAuthCode
                + "&redirect_uri=" + URLEncoder.encode(redirectUri, StringUtil.UTF8);
    }
}
