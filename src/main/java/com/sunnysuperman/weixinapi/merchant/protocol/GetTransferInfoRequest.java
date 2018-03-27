package com.sunnysuperman.weixinapi.merchant.protocol;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class GetTransferInfoRequest extends PayApiRequest {
    private String appid; // 商户号的appid
    private String partner_trade_no;// 商户订单号

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

}
