package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetOrderResponse {

    private Order order;

    public static class Order {
        private Long order_id;
        private String out_order_id;
        private Integer status;
        private String path;
        private AftersaleInfo related_aftersale_info;
        private OrderDetail order_detail;

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

        public AftersaleInfo getRelated_aftersale_info() {
            return related_aftersale_info;
        }

        public void setRelated_aftersale_info(AftersaleInfo related_aftersale_info) {
            this.related_aftersale_info = related_aftersale_info;
        }

        public OrderDetail getOrder_detail() {
            return order_detail;
        }

        public void setOrder_detail(OrderDetail order_detail) {
            this.order_detail = order_detail;
        }
    }

    public static class AftersaleInfo {
        private List<Aftersale> aftersale_list;

        public List<Aftersale> getAftersale_list() {
            return aftersale_list;
        }

        public void setAftersale_list(List<Aftersale> aftersale_list) {
            this.aftersale_list = aftersale_list;
        }
    }

    public static class Aftersale {
        private Long aftersale_id;
        private String out_aftersale_id;

        public Long getAftersale_id() {
            return aftersale_id;
        }

        public void setAftersale_id(Long aftersale_id) {
            this.aftersale_id = aftersale_id;
        }

        public String getOut_aftersale_id() {
            return out_aftersale_id;
        }

        public void setOut_aftersale_id(String out_aftersale_id) {
            this.out_aftersale_id = out_aftersale_id;
        }
    }

    public static class OrderDetail {

        private List<ProductInfo> product_infos;
        private PayInfo pay_info;
        private List<PayInfo> multi_pay_info;
        private PriceInfo price_info;
        private PromotionInfo promotion_info;
        private DeliveryDetail delivery_detail;

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

        public PromotionInfo getPromotion_info() {
            return promotion_info;
        }

        public void setPromotion_info(PromotionInfo promotion_info) {
            this.promotion_info = promotion_info;
        }

        public DeliveryDetail getDelivery_detail() {
            return delivery_detail;
        }

        public void setDelivery_detail(DeliveryDetail delivery_detail) {
            this.delivery_detail = delivery_detail;
        }
    }

    public static class PromotionInfo {

        private String promoter_id;
        private String finder_nickname;
        private String sharer_openid;

        public String getPromoter_id() {
            return promoter_id;
        }

        public void setPromoter_id(String promoter_id) {
            this.promoter_id = promoter_id;
        }

        public String getFinder_nickname() {
            return finder_nickname;
        }

        public void setFinder_nickname(String finder_nickname) {
            this.finder_nickname = finder_nickname;
        }

        public String getSharer_openid() {
            return sharer_openid;
        }

        public void setSharer_openid(String sharer_openid) {
            this.sharer_openid = sharer_openid;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
