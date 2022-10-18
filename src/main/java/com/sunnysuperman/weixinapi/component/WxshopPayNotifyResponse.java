package com.sunnysuperman.weixinapi.component;

public class WxshopPayNotifyResponse {

    private String msgType;
    private String createTime;
    private String event;
    private OrderInfo order_info;

    public static class OrderInfo {

        private String out_order_id;
        private String order_id;
        private String transaction_id;
        private String pay_time;

        public String getOut_order_id() {
            return out_order_id;
        }

        public void setOut_order_id(String out_order_id) {
            this.out_order_id = out_order_id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public OrderInfo getOrder_info() {
        return order_info;
    }

    public void setOrder_info(OrderInfo order_info) {
        this.order_info = order_info;
    }
}
