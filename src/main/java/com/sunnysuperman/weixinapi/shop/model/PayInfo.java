package com.sunnysuperman.weixinapi.shop.model;

public class PayInfo {
    private String pay_method;
    private String prepay_id;
    private String prepay_time;
    private String transaction_id;
    private String pay_time;
    private Integer pay_method_type;

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getPrepay_time() {
        return prepay_time;
    }

    public void setPrepay_time(String prepay_time) {
        this.prepay_time = prepay_time;
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

    public Integer getPay_method_type() {
        return pay_method_type;
    }

    public void setPay_method_type(Integer pay_method_type) {
        this.pay_method_type = pay_method_type;
    }
}