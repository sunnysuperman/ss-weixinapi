package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

/**
 * @see <a href=
 *      "https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/business-capabilities/ministore/minishopopencomponent2/API/order/get_order.html">get
 *      order</a>
 */
public class GetMiniShopOrderResponse {

    private Order order;

    public static class Order {
        private AftersaleInfo related_aftersale_info;

        private OrderDetail order_detail;

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

        private PromotionInfo promotion_info;

        public PromotionInfo getPromotion_info() {
            return promotion_info;
        }

        public void setPromotion_info(PromotionInfo promotion_info) {
            this.promotion_info = promotion_info;
        }
    }

    public static class PromotionInfo {

        private String finder_nickname;

        public String getFinder_nickname() {
            return finder_nickname;
        }

        public void setFinder_nickname(String finder_nickname) {
            this.finder_nickname = finder_nickname;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}