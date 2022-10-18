package com.sunnysuperman.weixinapi.shop.model;

public class DeliveryDetail {

    private int delivery_type = 1;
    private Integer finish_all_delivery;
    private DeliveryInfo[] delivery_list;

    public static class DeliveryInfo{
        private String delivery_id;
        private String waybill_id;
        private ProductInfo[] product_info_list;

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

        public ProductInfo[] getProduct_info_list() {
            return product_info_list;
        }

        public void setProduct_info_list(ProductInfo[] product_info_list) {
            this.product_info_list = product_info_list;
        }
    }

    public int getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(int delivery_type) {
        this.delivery_type = delivery_type;
    }

    public Integer getFinish_all_delivery() {
        return finish_all_delivery;
    }

    public void setFinish_all_delivery(Integer finish_all_delivery) {
        this.finish_all_delivery = finish_all_delivery;
    }

    public DeliveryInfo[] getDelivery_list() {
        return delivery_list;
    }

    public void setDelivery_list(DeliveryInfo[] delivery_list) {
        this.delivery_list = delivery_list;
    }
}
