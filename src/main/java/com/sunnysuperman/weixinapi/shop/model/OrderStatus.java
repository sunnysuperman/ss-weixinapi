package com.sunnysuperman.weixinapi.shop.model;

public enum OrderStatus {
    TO_PAY(10),

    PAID(11),

    TO_RECEIVE(20),

    COMPLETED(100),

    AFTER_SALE(200),

    CLOSED(250);

    private int val;

    private OrderStatus(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }

    public static OrderStatus valOf(int val) {
        for (OrderStatus item : OrderStatus.values()) {
            if (item.val == val) {
                return item;
            }
        }
        return null;
    }
}
