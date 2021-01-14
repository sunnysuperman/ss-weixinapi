package com.sunnysuperman.weixinapi.qrcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinQrcodeApi extends TokenAwareWeixinApi {

    public WeixinQrcodeApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
    }

    public WeixinQrcodeApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public WeixinQrCode create(boolean forever, Integer id, String strId, int expireIn) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        if (expireIn <= 0) {
            expireIn = 2592000;
        }
        Map<String, Object> scene = new HashMap<>();
        boolean useStrId = strId != null;
        String actionName;
        if (useStrId) {
            if (forever) {
                actionName = "QR_LIMIT_STR_SCENE";
            } else {
                actionName = "QR_STR_SCENE";
            }
            scene.put("scene_str", strId);
        } else {
            if (forever) {
                actionName = "QR_LIMIT_SCENE";
            } else {
                actionName = "QR_SCENE";
            }
            scene.put("scene_id", id);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("expire_seconds", expireIn);
        params.put("action_name", actionName);
        params.put("action_info", Collections.singletonMap("scene", scene));
        return postJSON("cgi-bin/qrcode/create?access_token=" + accessToken, params, new WeixinQrCode());
    }

}
