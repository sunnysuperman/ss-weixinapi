package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class Delivery {
    private String delivery_id;
    private String waybill_id;
    private List<ProductInfo> product_info_list;

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getWaybill_id() {
        return waybill_id;
    }

    public void setWaybill_id(String waybill_id) {
        this.waybill_id = waybill_id;
    }

    public List<ProductInfo> getProduct_info_list() {
        return product_info_list;
    }

    public void setProduct_info_list(List<ProductInfo> product_info_list) {
        this.product_info_list = product_info_list;
    }
}