package com.sunnysuperman.weixinapi.exception;

public class WeixinApiException extends Exception {
    private static final long serialVersionUID = 3608857923905727509L;

    private int errorCode;
    private String errorMsg;

    public WeixinApiException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public WeixinApiException(Throwable cause, int errorCode, String errorMsg) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
