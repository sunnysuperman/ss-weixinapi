package com.sunnysuperman.weixinapi.component;

public class WxshopAftersaleResponse {

    private AftersaleInfo aftersale_info;

    public static class AftersaleInfo {
        private Long aftersale_id;
        private Long order_id;
        private String out_order_id;

        public Long getAftersale_id() {
            return aftersale_id;
        }

        public void setAftersale_id(Long aftersale_id) {
            this.aftersale_id = aftersale_id;
        }

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
    }

    public AftersaleInfo getAftersale_info() {
        return aftersale_info;
    }

    public void setAftersale_info(AftersaleInfo aftersale_info) {
        this.aftersale_info = aftersale_info;
    }
}
