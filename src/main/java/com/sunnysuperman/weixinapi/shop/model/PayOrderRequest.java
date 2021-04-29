package com.sunnysuperman.weixinapi.shop.model;

public class PayOrderRequest {
    private Long order_id;
    private String out_order_id;
    private String openid;
    private Integer action_type;
    private String action_remark;
    private String transaction_id;
    private String pay_time;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOut_order_id() {
        return out_order_id;
    }

    public void setOut_order_id(String out_order_id) {
        this.out_order_id = out_order_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getAction_type() {
        return action_type;
    }

    public void setAction_type(Integer action_type) {
        this.action_type = action_type;
    }

    public String getAction_remark() {
        return action_remark;
    }

    public void setAction_remark(String action_remark) {
        this.action_remark = action_remark;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

}
