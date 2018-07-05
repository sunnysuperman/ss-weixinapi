package com.sunnysuperman.weixinapi.test;

import java.util.Map;

import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.component.WeixinComponentApi;

public class ComponentApiTest extends BaseTest {
    private WeixinComponentApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("component.appid"), getString("component.secret"), WeixinAppType.comp,
                getString("component.app-token"), getString("component.app-aes-key"));
        api = new WeixinComponentApi(app);
    }

    public void test_decryptMessage() throws Exception {
        Map<String, Object> msg = api.decryptMessage(getString("component.postdata"), getString("component.signature"),
                getString("component.timestamp"), getString("component.nonce"));
        System.out.println(JSONUtil.toJSONString(msg));
    }
}
