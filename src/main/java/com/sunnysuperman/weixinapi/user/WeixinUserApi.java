package com.sunnysuperman.weixinapi.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinUserApi extends TokenAwareWeixinApi {

    public WeixinUserApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public String getAuthorizeUrl(String redirectUrl, String componentAppId) {
        StringBuilder buf;
        try {
            buf = new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?appid=").append(app.getAppId())
                    .append("&redirect_uri=").append(URLEncoder.encode(redirectUrl, StringUtil.UTF8))
                    .append("&response_type=code&scope=snsapi_userinfo&state=");
            if (componentAppId != null) {
                buf.append("&component_appid=").append(componentAppId);
            }
            buf.append("#wechat_redirect");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return buf.toString();
    }

    public GetAccessTokenResponse getAccessToken(String code) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "authorization_code");
        params.put("appid", app.getAppId());
        params.put("code", code);
        params.put("secret", app.getAppSecret());
        return get("sns/oauth2/access_token", params, new GetAccessTokenResponse());
    }

    public GetAccessTokenResponse getAccessToken(String code, String componentAppId, String componentAccessToken)
            throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "authorization_code");
        params.put("appid", app.getAppId());
        params.put("code", code);
        if (componentAppId != null) {
            params.put("component_appid", componentAppId);
            params.put("component_access_token", componentAccessToken);
        }
        return get("sns/oauth2/component/access_token", params, new GetAccessTokenResponse());
    }

    public RefreshTokenResponse refreshToken(String refreshToken) throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "refresh_token");
        params.put("appid", app.getAppId());
        params.put("refresh_token", refreshToken);
        return get("sns/oauth2/refresh_token", params, new RefreshTokenResponse());
    }

    public GetUserInfoResponse findUserInfoByUserToken(String openid, String accessToken, String refreshToken)
            throws WeixinApiException {
        Map<String, Object> params = new HashMap<>();
        params.put("openid", openid);
        params.put("access_token", accessToken);
        try {
            return get("sns/userinfo", params, new GetUserInfoResponse());
        } catch (WeixinApiException e) {
            if (e.getErrorCode() > 0) {
                // weixin service error, access token is stale probably.
                if (refreshToken != null) {
                    RefreshTokenResponse tokenResponse = refreshToken(refreshToken);
                    return findUserInfoByUserToken(openid, tokenResponse.getAccess_token(), null);
                }
            }
            throw e;
        }
    }

    public GetUserInfoResponse findUserInfoByGlobalAccessToken(String openid) throws WeixinApiException {
        String accessToken = tokenGetter == null ? null : tokenGetter.getAccessToken();
        if (accessToken == null) {
            return null;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("openid", openid);
        params.put("access_token", accessToken);
        return get("cgi-bin/user/info", params, new GetUserInfoResponse());
    }

    public GetUserInfoResponse getUserinfo(String openid, String accessToken, String refreshToken)
            throws WeixinApiException {
        GetUserInfoResponse userinfo = findUserInfoByGlobalAccessToken(openid);
        if (userinfo == null || userinfo.getSubscribe() == 0) {
            // userinfo为空一般是错误情况,暂时视为已关注，subscribe=0表示未关注
            byte subscribe = userinfo == null ? 1 : userinfo.getSubscribe();
            userinfo = findUserInfoByUserToken(openid, accessToken, refreshToken);
            if (userinfo == null) {
                throw new WeixinApiException(-1, "Failed to getUserInfo of " + getApp().getAppId() + " / " + openid);
            }
            userinfo.setSubscribe(subscribe);
        }
        return userinfo;
    }

    public GetUsersResponse getUsers(String nextOpenid) throws WeixinApiException {
        String accessToken = tokenGetter == null ? null : tokenGetter.getAccessToken();
        if (accessToken == null) {
            return null;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        if (nextOpenid != null) {
            params.put("next_openid", nextOpenid);
        }
        return get("cgi-bin/user/get", params, new GetUsersResponse());
    }
}
