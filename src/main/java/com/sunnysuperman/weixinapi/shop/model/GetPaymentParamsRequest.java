package com.sunnysuperman.weixinapi.shop.model;

public class GetPaymentParamsRequest extends TradeBaseInfo {

    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
