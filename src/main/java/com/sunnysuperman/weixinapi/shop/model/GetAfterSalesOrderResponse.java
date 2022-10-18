package com.sunnysuperman.weixinapi.shop.model;

public class GetAfterSalesOrderResponse {

    private AfterSalesOrder after_sales_order;

    public static class AfterSalesOrder {

        private String out_aftersale_id;

        public String getOut_aftersale_id() {
            return out_aftersale_id;
        }

        public void setOut_aftersale_id(String out_aftersale_id) {
            this.out_aftersale_id = out_aftersale_id;
        }
    }

    public String outAftersaleId() {
        if (this.after_sales_order == null) {
            return null;
        }
        return this.after_sales_order.out_aftersale_id;
    }

    public AfterSalesOrder getAfter_sales_order() {
        return after_sales_order;
    }

    public void setAfter_sales_order(AfterSalesOrder after_sales_order) {
        this.after_sales_order = after_sales_order;
    }
}
