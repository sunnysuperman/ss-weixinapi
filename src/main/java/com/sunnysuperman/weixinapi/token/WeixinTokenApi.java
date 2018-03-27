package com.sunnysuperman.weixinapi.token;

import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.WeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinTokenApi extends WeixinApi {

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

    public GetJsTicketResponse getJsTicket(String globalAccessToken) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", globalAccessToken);
        params.put("type", "jsapi");
        return get("cgi-bin/ticket/getticket", params, new GetJsTicketResponse());
    }

}
