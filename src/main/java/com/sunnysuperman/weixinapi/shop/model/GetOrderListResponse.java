package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetOrderListResponse {

    public static class DeliveryProductInfo {
        private String waybill_id;
        private String delivery_id;

        public String getWaybill_id() {
            return waybill_id;
        }

        public void setWaybill_id(String waybill_id) {
            this.waybill_id = waybill_id;
        }

        public String getDelivery_id() {
            return delivery_id;
        }

        public void setDelivery_id(String delivery_id) {
            this.delivery_id = delivery_id;
        }

    }

    public static class AddressInfo {
        private String username;
        private String tel_number;
        private String postal_code;
        private String national_code;
        private String province_name;
        private String city_name;
        private String county_name;
        private String detail_info;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTel_number() {
            return tel_number;
        }

        public void setTel_number(String tel_number) {
            this.tel_number = tel_number;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getNational_code() {
            return national_code;
        }

        public void setNational_code(String national_code) {
            this.national_code = national_code;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCounty_name() {
            return county_name;
        }

        public void setCounty_name(String county_name) {
            this.county_name = county_name;
        }

        public String getDetail_info() {
            return detail_info;
        }

        public void setDetail_info(String detail_info) {
            this.detail_info = detail_info;
        }

    }

    public static class DeliveryInfo {
        private String delivery_method;
        private String delivery_time;
        private DeliveryProductInfo delivery_product_info;
        private AddressInfo address_info;

        public String getDelivery_method() {
            return delivery_method;
        }

        public void setDelivery_method(String delivery_method) {
            this.delivery_method = delivery_method;
        }

        public String getDelivery_time() {
            return delivery_time;
        }

        public void setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
        }

        public DeliveryProductInfo getDelivery_product_info() {
            return delivery_product_info;
        }

        public void setDelivery_product_info(DeliveryProductInfo delivery_product_info) {
            this.delivery_product_info = delivery_product_info;
        }

        public AddressInfo getAddress_info() {
            return address_info;
        }

        public void setAddress_info(AddressInfo address_info) {
            this.address_info = address_info;
        }

    }

    public static class AfterSaleOrder {
        private long aftersale_order_id;

        public long getAftersale_order_id() {
            return aftersale_order_id;
        }

        public void setAftersale_order_id(long aftersale_order_id) {
            this.aftersale_order_id = aftersale_order_id;
        }

    }

    public static class AfterSaleDetail {
        private int on_aftersale_order_cnt;
        private List<AfterSaleOrder> aftersale_order_list;

        public int getOn_aftersale_order_cnt() {
            return on_aftersale_order_cnt;
        }

        public void setOn_aftersale_order_cnt(int on_aftersale_order_cnt) {
            this.on_aftersale_order_cnt = on_aftersale_order_cnt;
        }

        public List<AfterSaleOrder> getAftersale_order_list() {
            return aftersale_order_list;
        }

        public void setAftersale_order_list(List<AfterSaleOrder> aftersale_order_list) {
            this.aftersale_order_list = aftersale_order_list;
        }

    }

    public static class OrderExtInfo {
        private String customer_notes;
        private String merchant_notes;

        public String getCustomer_notes() {
            return customer_notes;
        }

        public void setCustomer_notes(String customer_notes) {
            this.customer_notes = customer_notes;
        }

        public String getMerchant_notes() {
            return merchant_notes;
        }

        public void setMerchant_notes(String merchant_notes) {
            this.merchant_notes = merchant_notes;
        }

    }

    public static class Order {
        private Long order_id;
        private Integer status;
        private String create_time;
        private String update_time;
        private String openid;
        private OrderDetail order_detail;
        private AfterSaleDetail aftersale_detail;
        private OrderExtInfo ext_info;

        public Long getOrder_id() {
            return order_id;
        }

        public void setOrder_id(Long order_id) {
            this.order_id = order_id;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public OrderDetail getOrder_detail() {
            return order_detail;
        }

        public void setOrder_detail(OrderDetail order_detail) {
            this.order_detail = order_detail;
        }

        public AfterSaleDetail getAftersale_detail() {
            return aftersale_detail;
        }

        public void setAftersale_detail(AfterSaleDetail aftersale_detail) {
            this.aftersale_detail = aftersale_detail;
        }

        public OrderExtInfo getExt_info() {
            return ext_info;
        }

        public void setExt_info(OrderExtInfo ext_info) {
            this.ext_info = ext_info;
        }

    }

    private int total_num;
    private List<Order> orders;

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
