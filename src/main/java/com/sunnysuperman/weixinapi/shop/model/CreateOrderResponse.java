package com.sunnysuperman.weixinapi.shop.model;

public class CreateOrderResponse {

    public static class Data {
        private Long order_id;
        private String out_order_id;
        private String ticket;
        private String ticket_expire_time;
        private Long final_price;

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

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public String getTicket_expire_time() {
            return ticket_expire_time;
        }

        public void setTicket_expire_time(String ticket_expire_time) {
            this.ticket_expire_time = ticket_expire_time;
        }

        public Long getFinal_price() {
            return final_price;
        }

        public void setFinal_price(Long final_price) {
            this.final_price = final_price;
        }
    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
