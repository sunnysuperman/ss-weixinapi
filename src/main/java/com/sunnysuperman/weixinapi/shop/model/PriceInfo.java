package com.sunnysuperman.weixinapi.shop.model;

public class PriceInfo {
    private Long product_price;
    private Long order_price;
    private Long freight;
    private Long discounted_price;
    private Long additional_price;
    private String additional_remarks;
    private Boolean is_discounted;

    public Long getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Long product_price) {
        this.product_price = product_price;
    }

    public Long getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Long order_price) {
        this.order_price = order_price;
    }

    public Long getFreight() {
        return freight;
    }

    public void setFreight(Long freight) {
        this.freight = freight;
    }

    public Long getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(Long discounted_price) {
        this.discounted_price = discounted_price;
    }

    public Long getAdditional_price() {
        return additional_price;
    }

    public void setAdditional_price(Long additional_price) {
        this.additional_price = additional_price;
    }

    public String getAdditional_remarks() {
        return additional_remarks;
    }

    public void setAdditional_remarks(String additional_remarks) {
        this.additional_remarks = additional_remarks;
    }

    public Boolean getIs_discounted() {
        return is_discounted;
    }

    public void setIs_discounted(Boolean is_discounted) {
        this.is_discounted = is_discounted;
    }

}