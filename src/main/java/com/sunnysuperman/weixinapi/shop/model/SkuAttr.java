package com.sunnysuperman.weixinapi.shop.model;

public class SkuAttr {
    private String attr_key;
    private String attr_value;

    public SkuAttr() {
        super();
    }

    public SkuAttr(String attr_key, String attr_value) {
        super();
        this.attr_key = attr_key;
        this.attr_value = attr_value;
    }

    public String getAttr_key() {
        return attr_key;
    }

    public void setAttr_key(String attr_key) {
        this.attr_key = attr_key;
    }

    public String getAttr_value() {
        return attr_value;
    }

    public void setAttr_value(String attr_value) {
        this.attr_value = attr_value;
    }

}