package com.sunnysuperman.weixinapi.test;

import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.mini.GetMiniSessionResponse;
import com.sunnysuperman.weixinapi.mini.MiniUserInfo;
import com.sunnysuperman.weixinapi.mini.WeixinMiniApi;

public class MiniApiTest extends BaseTest {
    private WeixinMiniApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("mini.appid"), getString("mini.secret"), WeixinAppType.mini);
        api = new WeixinMiniApi(app);
    }

    public void test_getSession() throws Exception {
        GetMiniSessionResponse response = api.getSession(getString("mini.code"));
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_decryptUserInfo() throws Exception {
        MiniUserInfo response = api.decryptUserInfo(getString("mini.encryptedData"), getString("mini.sessionKey"),
                getString("mini.iv"), findString("mini.rawData"), getString("mini.signature"));
        System.out.println(JSONUtil.toJSONString(response));
    }

}
