package com.sunnysuperman.weixinapi.test;

import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.token.GetGlobalAccessTokenResponse;
import com.sunnysuperman.weixinapi.token.WeixinTokenApi;

public class TokenApiTest extends BaseTest {

    public void test_getGlobalAccessToken() throws Exception {
        WeixinApp app = new WeixinApp("", "", WeixinAppType.mp);
        WeixinTokenApi api = new WeixinTokenApi(app);
        GetGlobalAccessTokenResponse response = api.getGlobalAccessToken();
        System.out.println(response.getAccess_token());
        System.out.println(response.getExpires_in());
    }

    public void test_clearQuota() throws Exception {
        WeixinApp app = new WeixinApp("", "", WeixinAppType.mp);
        WeixinTokenApi api = new WeixinTokenApi(app);
        api.clearQuota("");
    }
}
