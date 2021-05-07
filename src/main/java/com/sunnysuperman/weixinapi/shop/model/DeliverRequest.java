package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class DeliverRequest {
    private String order_id;
    private String out_order_id;
    private String openid;
    private byte finish_all_delivery;
    private List<Delivery> delivery_list;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public byte getFinish_all_delivery() {
        return finish_all_delivery;
    }

    public void setFinish_all_delivery(byte finish_all_delivery) {
        this.finish_all_delivery = finish_all_delivery;
    }

    public List<Delivery> getDelivery_list() {
        return delivery_list;
    }

    public void setDelivery_list(List<Delivery> delivery_list) {
        this.delivery_list = delivery_list;
    }

}
