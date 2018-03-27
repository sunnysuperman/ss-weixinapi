package com.sunnysuperman.weixinapi.merchant.protocol;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class QueryOrderRequest extends PayApiRequest {
    private String appid; // 商户号的appid
    private String transaction_id;// 微信订单号
    private String out_trade_no;// 微信订单号

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

}
