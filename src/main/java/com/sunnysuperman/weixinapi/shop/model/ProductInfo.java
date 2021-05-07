package com.sunnysuperman.weixinapi.shop.model;

public class ProductInfo {
    private String out_product_id;
    private String out_sku_id;
    private String head_img;
    private String title;
    private String path;
    private Integer product_cnt;
    private Long sale_price;

    public String getOut_product_id() {
        return out_product_id;
    }

    public void setOut_product_id(String out_product_id) {
        this.out_product_id = out_product_id;
    }

    public String getOut_sku_id() {
        return out_sku_id;
    }

    public void setOut_sku_id(String out_sku_id) {
        this.out_sku_id = out_sku_id;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getProduct_cnt() {
        return product_cnt;
    }

    public void setProduct_cnt(Integer product_cnt) {
        this.product_cnt = product_cnt;
    }

    public Long getSale_price() {
        return sale_price;
    }

    public void setSale_price(Long sale_price) {
        this.sale_price = sale_price;
    }

}