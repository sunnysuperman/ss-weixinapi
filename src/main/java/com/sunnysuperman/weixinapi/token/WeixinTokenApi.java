package com.sunnysuperman.weixinapi.token;

import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.WeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinTokenApi extends WeixinApi {

    public WeixinTokenApi(WeixinApp app, HttpClientFactory httpClientFactory) {
        super(app, httpClientFactory);
    }

    public WeixinTokenApi(WeixinApp app) {
        super(app);
    }

    public GetGlobalAccessTokenResponse getGlobalAccessToken() throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", app.getAppId());
        params.put("secret", app.getAppSecret());
        return get("cgi-bin/token", params, new GetGlobalAccessTokenResponse());
    }

    public GetTicketResponse getTicket(String accessToken, String type) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("type", type);
        return get("cgi-bin/ticket/getticket", params, new GetTicketResponse());
    }

    public GetTicketResponse getJsTicket(String accessToken) throws WeixinApiException {
        return getTicket(accessToken, "jsapi");
    }

    public void clearQuota(String accessToken) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", app.getAppId());
        postJSON("cgi-bin/clear_quota?access_token=" + accessToken, params, new BaseResponse());
    }

}
