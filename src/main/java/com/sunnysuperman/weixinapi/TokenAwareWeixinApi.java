package com.sunnysuperman.weixinapi;

public abstract class TokenAwareWeixinApi extends WeixinApi {
    protected WeixinAppTokenGetter tokenGetter;

    public TokenAwareWeixinApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app);
        this.tokenGetter = tokenGetter;
    }

    public WeixinAppTokenGetter getTokenGetter() {
        return tokenGetter;
    }

}
