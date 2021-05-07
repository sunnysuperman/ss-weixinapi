package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetOrderResponse {

    public static class OrderDetail {
        private List<ProductInfo> product_infos;
        private PayInfo pay_info;
        private List<PayInfo> multi_pay_info;
        private PriceInfo price_info;

        public List<ProductInfo> getProduct_infos() {
            return product_infos;
        }

        public void setProduct_infos(List<ProductInfo> product_infos) {
            this.product_infos = product_infos;
        }

        public PayInfo getPay_info() {
            return pay_info;
        }

        public void setPay_info(PayInfo pay_info) {
            this.pay_info = pay_info;
        }

        public List<PayInfo> getMulti_pay_info() {
            return multi_pay_info;
        }

        public void setMulti_pay_info(List<PayInfo> multi_pay_info) {
            this.multi_pay_info = multi_pay_info;
        }

        public PriceInfo getPrice_info() {
            return price_info;
        }

        public void setPrice_info(PriceInfo price_info) {
            this.price_info = price_info;
        }

    }

    public static class DeliveryDetail {
        private Integer delivery_type;
        private Byte finish_all_delivery;
        private List<Delivery> delivery_list;

        public Integer getDelivery_type() {
            return delivery_type;
        }

        public void setDelivery_type(Integer delivery_type) {
            this.delivery_type = delivery_type;
        }

        public Byte getFinish_all_delivery() {
            return finish_all_delivery;
        }

        public void setFinish_all_delivery(Byte finish_all_delivery) {
            this.finish_all_delivery = finish_all_delivery;
        }

        public List<Delivery> getDelivery_list() {
            return delivery_list;
        }

        public void setDelivery_list(List<Delivery> delivery_list) {
            this.delivery_list = delivery_list;
        }

    }

    public static class Order {
        private Long order_id;
        private String out_order_id;
        private String openid;
        private String create_time;
        private Integer status;
        private String path;
        private OrderDetail order_detail;
        private DeliveryDetail delivery_detail;
        private AddressInfo address_info;

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

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public OrderDetail getOrder_detail() {
            return order_detail;
        }

        public void setOrder_detail(OrderDetail order_detail) {
            this.order_detail = order_detail;
        }

        public DeliveryDetail getDelivery_detail() {
            return delivery_detail;
        }

        public void setDelivery_detail(DeliveryDetail delivery_detail) {
            this.delivery_detail = delivery_detail;
        }

        public AddressInfo getAddress_info() {
            return address_info;
        }

        public void setAddress_info(AddressInfo address_info) {
            this.address_info = address_info;
        }

    }

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
