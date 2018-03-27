package com.sunnysuperman.weixinapi.merchant.protocol;

import com.sunnysuperman.weixinapi.util.WeixinHelper;

public class PayApiRequest {
    private String sign;
    private String mch_id;
    private String nonce_str = WeixinHelper.randomAlphanumeric(32);

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

}
