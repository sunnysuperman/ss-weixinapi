package com.sunnysuperman.weixinapi.shop.model;

public class AfterSaleAddRequest {
    private String order_id;
    private String out_order_id;
    private String out_aftersale_id;
    private String openid;
    private Integer type = 1;
    private ProductInfo product_info;
    private Long orderamt;
    private String refund_reason = "不想要了";
    private int refund_reason_type = 2;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOut_order_id() {
        return out_order_id;
    }

    public void setOut_order_id(String out_order_id) {
        this.out_order_id = out_order_id;
    }

    public String getOut_aftersale_id() {
        return out_aftersale_id;
    }

    public void setOut_aftersale_id(String out_aftersale_id) {
        this.out_aftersale_id = out_aftersale_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ProductInfo getProduct_info() {
        return product_info;
    }

    public void setProduct_info(ProductInfo product_info) {
        this.product_info = product_info;
    }

    public Long getOrderamt() {
        return orderamt;
    }

    public void setOrderamt(Long orderamt) {
        this.orderamt = orderamt;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public int getRefund_reason_type() {
        return refund_reason_type;
    }

    public void setRefund_reason_type(int refund_reason_type) {
        this.refund_reason_type = refund_reason_type;
    }
}