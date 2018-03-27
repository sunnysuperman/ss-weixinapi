package com.sunnysuperman.weixinapi.exception;

public class WeixinBadAccessTokenException extends WeixinApiException {
    private static final long serialVersionUID = -8673678643191922035L;

    public WeixinBadAccessTokenException() {
        super(-1, "Failed to get access token");
    }

    public WeixinBadAccessTokenException(String msg) {
        super(-1, msg);
    }

    public WeixinBadAccessTokenException(Throwable cause) {
        super(cause, -1, "Failed to get access token");
    }

}
