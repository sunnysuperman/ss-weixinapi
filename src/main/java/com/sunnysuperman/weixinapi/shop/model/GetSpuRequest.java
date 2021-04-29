package com.sunnysuperman.weixinapi.shop.model;

public class GetSpuRequest {
    private Long product_id;
    private String out_product_id;
    private int need_edit_spu;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getOut_product_id() {
        return out_product_id;
    }

    public void setOut_product_id(String out_product_id) {
        this.out_product_id = out_product_id;
    }

    public int getNeed_edit_spu() {
        return need_edit_spu;
    }

    public void setNeed_edit_spu(int need_edit_spu) {
        this.need_edit_spu = need_edit_spu;
    }

}
