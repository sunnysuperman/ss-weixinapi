package com.sunnysuperman.weixinapi.test;

import java.io.File;

import com.sunnysuperman.commons.util.FileUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.material.Material;
import com.sunnysuperman.weixinapi.material.WeixinMaterialApi;

public class MaterialApiTest extends BaseTest {
    private WeixinMaterialApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("mp.appid"), getString("mp.secret"), WeixinAppType.mini);
        api = new WeixinMaterialApi(app, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mp.access-token");
            }

        });
    }

    public void test_addMaterial() throws Exception {
        File file = FileUtil
                .getFile(new String[] { System.getProperty("user.dir"), "src/test/resources/test-resources/1.jpeg" });
        String fileName = "test_materialxx.jpg";
        Material material = api.addMaterial("image", file, fileName);
        System.out.println(JSONUtil.toJSONString(material));
        assertTrue(material != null);
        assertTrue(material.getMedia_id() != null);
        assertTrue(material.getUrl() != null);
    }

}
