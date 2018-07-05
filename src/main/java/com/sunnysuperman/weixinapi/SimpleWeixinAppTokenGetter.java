package com.sunnysuperman.weixinapi;

import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;

public class SimpleWeixinAppTokenGetter implements WeixinAppTokenGetter {
    private String accessToken;

    public SimpleWeixinAppTokenGetter(String accessToken) {
        super();
        this.accessToken = accessToken;
    }

    @Override
    public String getAccessToken() throws WeixinBadAccessTokenException {
        return accessToken;
    }

}
