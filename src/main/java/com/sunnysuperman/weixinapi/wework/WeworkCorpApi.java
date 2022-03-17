package com.sunnysuperman.weixinapi.wework;

import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeworkCorpApi extends TokenAwareWeworkApi {

    protected WeworkSuitApi workApi;

    public WeworkCorpApi(WeixinApp app, WeixinAppTokenGetter tokenGetter, WeworkSuitApi workApi) {
        super(app, tokenGetter);
        this.workApi = workApi;
    }

    public WeworkCorpApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter,
            WeworkSuitApi workApi) {
        super(app, httpClientFactory, tokenGetter);
        if (app.getAppType() != WeixinAppType.corporation) {
            throw new RuntimeException("Not a wework corporation app");
        }
        this.workApi = workApi;
    }

    public GetAccessTokenResponse getAccessToken() throws WeixinApiException {
        String accessToken = workApi.ensureAccessToken();
        Map<String, Object> map = new HashMap<>(2);
        map.put("permanent_code", app.getAppSecret());
        map.put("auth_corpid", app.getAppId());
        return postJSON("/cgi-bin/service/get_corp_token?suite_access_token=" + accessToken, map,
                new GetAccessTokenResponse());
    }
}
