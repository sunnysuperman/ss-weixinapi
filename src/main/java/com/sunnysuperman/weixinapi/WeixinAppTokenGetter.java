package com.sunnysuperman.weixinapi;

import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;

public interface WeixinAppTokenGetter {

    String getAccessToken() throws WeixinBadAccessTokenException;

    // String getJsTicket() throws WeixinBadAccessTokenException;

}
