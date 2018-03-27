package com.sunnysuperman.weixinapi.mini;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.WeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.prototype.PKCS7Encoder;

public class WeixinMiniApi extends WeixinApi {

    public WeixinMiniApi(WeixinApp app) {
        super(app);
        if (app.getAppType() != WeixinAppType.mini) {
            throw new RuntimeException("Not a miniprogram weixin app");
        }
    }

    public GetMiniSessionResponse getSession(String code) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", app.getAppId());
        params.put("secret", app.getAppSecret());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        return get("sns/jscode2session", params, new GetMiniSessionResponse());
    }

    public MiniUserInfo decryptUserInfo(String encryptedData, String sessionKey, String iv, String rawData,
            String signature) throws WeixinApiException {
        if (rawData != null) {
            String realSignature = DigestUtils.sha1Hex(rawData + sessionKey);
            if (!signature.equals(realSignature)) {
                throw new WeixinApiException(-1, "Bad signature");
            }
        }
        byte[] contentBytes;
        try {
            contentBytes = MiniAesUtil.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey),
                    Base64.decodeBase64(iv));
        } catch (Exception e) {
            throw new WeixinApiException(e, -1, "Failed to decode encrypted data");
        }
        String userInfo = new String(PKCS7Encoder.decode(contentBytes), StringUtil.UTF8_CHARSET);
        return Bean.fromJson(userInfo, new MiniUserInfo());
    }

}
