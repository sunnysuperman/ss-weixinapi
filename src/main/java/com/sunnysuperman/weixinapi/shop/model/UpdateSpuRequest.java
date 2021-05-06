package com.sunnysuperman.weixinapi.shop.model;

public class UpdateSpuRequest extends AddSpuRequest {
    private Long product_id;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

}
