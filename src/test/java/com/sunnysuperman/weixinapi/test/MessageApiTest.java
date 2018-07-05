package com.sunnysuperman.weixinapi.test;

import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.message.SendCustomMessageRequest;
import com.sunnysuperman.weixinapi.message.WeixinMessageApi;

public class MessageApiTest extends BaseTest {
    private WeixinMessageApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("mp.appid"), getString("mp.secret"), WeixinAppType.mp);
        api = new WeixinMessageApi(app, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mp.access-token");
            }

        });
    }

    public void test_sendCustomMessage() throws Exception {
        SendCustomMessageRequest request = new SendCustomMessageRequest();
        request.setTouser("oyNtA0q0JFPiX9mflFweW8nwIvJs");
        request.setText("这是测试😓客服消息😓");
        api.sendCustomMessage(request);
    }
}
