package com.sunnysuperman.weixinapi.test;

import java.util.List;

import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.mini.GetMiniSessionResponse;
import com.sunnysuperman.weixinapi.mini.MiniSubmitItem;
import com.sunnysuperman.weixinapi.mini.MiniUserInfo;
import com.sunnysuperman.weixinapi.mini.WeixinMiniApi;

public class MiniApiTest extends BaseTest {
    private WeixinMiniApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("mini.appid"), getString("mini.secret"), WeixinAppType.mini);
        api = new WeixinMiniApi(app, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mini.access-token");
            }

        });
    }

    public void test_getSession() throws Exception {
        GetMiniSessionResponse response = api.getSession(getString("mini.code"));
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_getSession2() throws Exception {
        GetMiniSessionResponse response = api.getSession(getString("mini.code"), getString("component.appid"),
                getString("component.access-token"));
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_decryptUserInfo() throws Exception {
        MiniUserInfo response = api.decryptUserInfo(getString("mini.encryptedData"), getString("mini.sessionKey"),
                getString("mini.iv"), findString("mini.rawData"), getString("mini.signature"));
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_commit() throws Exception {
        api.commit("4", "{}", "V1.0.5", "APP名称");
    }

    @SuppressWarnings("unchecked")
    public void test_submit() throws Exception {
        api.submit((List<MiniSubmitItem>) JSONUtil.parseJSONArray(getString("mini.submit-items")));
    }

    public void test_getQrcode() throws Exception {
        System.out.println(api.getQrcode(null));
    }

    public void test_getAuditStatus() throws Exception {
        System.out.println(JSONUtil.toJSONString(api.getAuditStatus("522990941")));
    }

    public void test_getLatestAuditStatus() throws Exception {
        System.out.println(JSONUtil.toJSONString(api.getLatestAuditStatus()));
    }

    public void test_release() throws Exception {
        api.release();
    }

    public void test_undoAudit() throws Exception {
        api.undoAudit();
    }

}
