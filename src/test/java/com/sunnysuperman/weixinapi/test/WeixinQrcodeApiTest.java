package com.sunnysuperman.weixinapi.test;

import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.qrcode.WeixinQrCode;
import com.sunnysuperman.weixinapi.qrcode.WeixinQrcodeApi;

public class WeixinQrcodeApiTest extends BaseTest {

    public void test_create() throws Exception {
        WeixinApp app = new WeixinApp(getString("mp.appid"), "", WeixinAppType.mp);
        WeixinQrcodeApi api = new WeixinQrcodeApi(app, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return "12_7bQ6cc0EAbxKIAk6p43G0nepMO_a5vhGzVEPj5lbd-uGxwwFimhpAqs6Zz8xsUiwypDy7gyITuoyRAI6g5sU_Hmw4RNGmh3JiyfwP4s7SEHjbGiTCxJJo2iNaNInX39XXtYQoMWK1IoJ_ghTLDAeAEDCUR";
            }

        });
        WeixinQrCode qrcode = api.create(false, null, "tag:游戏", 0);
        System.out.println(JSONUtil.toJSONString(qrcode));
    }
}
