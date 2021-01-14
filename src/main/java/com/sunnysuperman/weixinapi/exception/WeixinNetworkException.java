package com.sunnysuperman.weixinapi.exception;

public class WeixinNetworkException extends WeixinApiException {
    private static final long serialVersionUID = -8673678643191922035L;
    private static final int ERROR_CODE = -1;

    public WeixinNetworkException() {
        super(ERROR_CODE, "Failed to get access token");
    }

    public WeixinNetworkException(String msg) {
        super(ERROR_CODE, msg);
    }

    public WeixinNetworkException(Throwable cause) {
        super(cause, ERROR_CODE, "Failed to get access token");
    }

}
