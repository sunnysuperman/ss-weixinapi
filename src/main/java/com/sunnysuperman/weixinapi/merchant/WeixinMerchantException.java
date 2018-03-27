package com.sunnysuperman.weixinapi.merchant;

public class WeixinMerchantException extends Exception {
    private static final long serialVersionUID = -2838347871619421631L;

    public WeixinMerchantException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeixinMerchantException(String message) {
        super(message);
    }

    public WeixinMerchantException(Throwable cause) {
        super(cause);
    }

}
