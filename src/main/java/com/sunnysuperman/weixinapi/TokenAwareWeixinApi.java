package com.sunnysuperman.weixinapi;

import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;

public abstract class TokenAwareWeixinApi extends WeixinApi {
    private WeixinAppTokenGetter tokenGetter;

    public TokenAwareWeixinApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app);
        this.tokenGetter = tokenGetter;
    }

    public TokenAwareWeixinApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory);
        this.tokenGetter = tokenGetter;
    }

    public WeixinAppTokenGetter getTokenGetter() {
        return tokenGetter;
    }

    public String ensureAccessToken() throws WeixinBadAccessTokenException {
        String accessToken = tokenGetter == null ? null : tokenGetter.getAccessToken();
        if (accessToken == null) {
            throw new WeixinBadAccessTokenException();
        }
        return accessToken;
    }
}
