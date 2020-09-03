package com.sunnysuperman.weixinapi.mini;

import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.prototype.PKCS7Encoder;
import com.sunnysuperman.weixinapi.util.DigestUtils;

public class WeixinMiniApi extends TokenAwareWeixinApi {

    public WeixinMiniApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
        if (app.getAppType() != WeixinAppType.mini) {
            throw new RuntimeException("Not a miniprogram weixin app");
        }
    }

    public WeixinMiniApi(WeixinApp app) {
        this(app, null);
    }

    public GetMiniSessionResponse getSession(String code, String componentAppId, String componentAccessToken)
            throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", app.getAppId());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        params.put("component_appid", componentAppId);
        params.put("component_access_token", componentAccessToken);
        return get("sns/component/jscode2session", params, new GetMiniSessionResponse());
    }

    public GetMiniSessionResponse getSession(String code) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", app.getAppId());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        params.put("secret", app.getAppSecret());
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
            contentBytes = MiniAesUtil.decrypt(Base64.getDecoder().decode(encryptedData),
                    Base64.getDecoder().decode(sessionKey), Base64.getDecoder().decode(iv));
        } catch (Exception e) {
            throw new WeixinApiException(e, -1, "Failed to decode encrypted data");
        }
        String userInfo = new String(PKCS7Encoder.decode(contentBytes), StringUtil.UTF8_CHARSET);
        return Bean.fromJson(userInfo, new MiniUserInfo());
    }

    public void setDomains(MiniServerDomains domains) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("action", "set");
        params.put("requestdomain", domains.getRequestdomain());
        params.put("wsrequestdomain", domains.getWsrequestdomain());
        params.put("uploaddomain", domains.getUploaddomain());
        params.put("downloaddomain", domains.getDownloaddomain());
        postJSON("wxa/modify_domain?access_token=" + getTokenGetter().getAccessToken(), params, new BaseResponse());
    }

    public MiniServerDomains getDomains() throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("action", "get");
        return postJSON("wxa/modify_domain?access_token=" + getTokenGetter().getAccessToken(), params,
                new MiniServerDomains());
    }

    public void setWebviewDomains(String[] domains) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("action", "set");
        params.put("webviewdomain", domains);
        try {
            postJSON("wxa/setwebviewdomain?access_token=" + getTokenGetter().getAccessToken(), params,
                    new BaseResponse());
        } catch (WeixinApiException e) {
            if (e.getErrorCode() == 89019) {
                // 业务域名无更改，无需重复设置
                return;
            }
            throw e;
        }
    }

    /**
     * 为授权的小程序帐号上传小程序代码
     */
    public void commit(Integer templateId, String extJson, String version, String desc) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("template_id", templateId);
        params.put("ext_json", extJson);
        params.put("user_version", version);
        params.put("user_desc", desc);
        postJSON("wxa/commit?access_token=" + getTokenGetter().getAccessToken(), params, new BaseResponse());
    }

    /**
     * 获取体验小程序的体验二维码URL
     */
    public String getReleaseQrcode(String path) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        if (path != null) {
            params.put("path", path);
        }
        return wrapApiUrl("wxa/get_qrcode?access_token=" + getTokenGetter().getAccessToken());
    }

    /**
     * 提交审核
     */
    public SubmitResponse submitAudit(List<MiniSubmitItem> items) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("item_list", items);
        return postJSON("wxa/submit_audit?access_token=" + getTokenGetter().getAccessToken(), params,
                new SubmitResponse());
    }

    /**
     * 查询某个提交的审核状态
     */
    public GetAuditStatusResponse getAuditStatus(String auditId) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("auditid", auditId);
        return postJSON("wxa/get_auditstatus?access_token=" + getTokenGetter().getAccessToken(), params,
                new GetAuditStatusResponse());
    }

    /**
     * 查询最后一次提交的审核状态
     */
    public GetAuditStatusResponse getLatestAuditStatus() throws WeixinApiException {
        return get("wxa/get_latest_auditstatus?access_token=" + getTokenGetter().getAccessToken(), null,
                new GetAuditStatusResponse());
    }

    /**
     * 发布已通过审核的小程序
     */
    public void release() throws WeixinApiException {
        postJSON("wxa/release?access_token=" + getTokenGetter().getAccessToken(), Collections.emptyMap(),
                new BaseResponse());
    }

    /**
     * 小程序审核撤回
     */
    public void undoAudit() throws WeixinApiException {
        get("wxa/undocodeaudit?access_token=" + getTokenGetter().getAccessToken(), null, new BaseResponse());
    }

    /**
     * 小程序版本回退
     */
    public void revertRelease() throws WeixinApiException {
        get("wxa/revertcoderelease?access_token=" + getTokenGetter().getAccessToken(), null, new BaseResponse());
    }

    /**
     * 发布已设置的二维码规则
     */
    public void publishQrcodeJump(String prefix) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("prefix", prefix);
        post("cgi-bin/wxopen/qrcodejumppublish?access_token=" + getTokenGetter().getAccessToken(), params,
                new BaseResponse());
    }

}
