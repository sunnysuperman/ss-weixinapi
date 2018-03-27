package com.sunnysuperman.weixinapi.merchant.protocol;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class GetRedpackRequest extends PayApiRequest {
    private String mch_billno; // 商户订单号
    private String appid; // 公众账号appid
    private String bill_type = "MCHT";// 订单类型

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

}
