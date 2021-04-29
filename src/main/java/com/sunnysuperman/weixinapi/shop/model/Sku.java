package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class Sku {
    private String out_product_id;
    private String out_sku_id;
    private String thumb_img;
    private long sale_price;
    private long market_price;
    private int stock_num;
    private String barcode;
    private String sku_code;
    private List<SkuAttr> sku_attrs;

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

    public String getThumb_img() {
        return thumb_img;
    }

    public void setThumb_img(String thumb_img) {
        this.thumb_img = thumb_img;
    }

    public long getSale_price() {
        return sale_price;
    }

    public void setSale_price(long sale_price) {
        this.sale_price = sale_price;
    }

    public long getMarket_price() {
        return market_price;
    }

    public void setMarket_price(long market_price) {
        this.market_price = market_price;
    }

    public int getStock_num() {
        return stock_num;
    }

    public void setStock_num(int stock_num) {
        this.stock_num = stock_num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public List<SkuAttr> getSku_attrs() {
        return sku_attrs;
    }

    public void setSku_attrs(List<SkuAttr> sku_attrs) {
        this.sku_attrs = sku_attrs;
    }

}