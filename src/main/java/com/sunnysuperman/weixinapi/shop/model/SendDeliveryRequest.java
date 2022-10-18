package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class SendDeliveryRequest {

    private String order_id;
    private String out_order_id;
    private String openid;
    private byte finish_all_delivery;
    private List<Delivery> delivery_list;
    private String ship_done_time;

    public static class Delivery {
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

    public String getShip_done_time() {
        return ship_done_time;
    }

    public void setShip_done_time(String ship_done_time) {
        this.ship_done_time = ship_done_time;
    }
}
