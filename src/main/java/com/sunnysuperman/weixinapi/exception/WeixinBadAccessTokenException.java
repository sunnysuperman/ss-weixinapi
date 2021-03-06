package com.sunnysuperman.weixinapi.exception;

public class WeixinBadAccessTokenException extends WeixinApiException {
    private static final long serialVersionUID = -8673678643191922035L;
    private static final int ERROR_CODE = -2;

    public WeixinBadAccessTokenException() {
        super(ERROR_CODE, "Failed to get access token");
    }

    public WeixinBadAccessTokenException(String msg) {
        super(ERROR_CODE, msg);
    }

    public WeixinBadAccessTokenException(Throwable cause) {
        super(cause, ERROR_CODE, "Failed to get access token");
    }

}
