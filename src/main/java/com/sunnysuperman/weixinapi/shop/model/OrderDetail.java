package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

import com.sunnysuperman.weixinapi.shop.model.GetOrderListResponse.DeliveryInfo;

public class OrderDetail {
    public static class ProductInfo {
        private Long product_id;
        private Long sku_id;
        private String thumb_img;
        private Double sale_price;
        private Integer sku_cnt;
        private Integer on_aftersale_sku_cnt;
        private Integer finish_aftersale_sku_cnt;
        private List<SkuAttr> sku_attrs;

        public Long getProduct_id() {
            return product_id;
        }

        public void setProduct_id(Long product_id) {
            this.product_id = product_id;
        }

        public Long getSku_id() {
            return sku_id;
        }

        public void setSku_id(Long sku_id) {
            this.sku_id = sku_id;
        }

        public String getThumb_img() {
            return thumb_img;
        }

        public void setThumb_img(String thumb_img) {
            this.thumb_img = thumb_img;
        }

        public Double getSale_price() {
            return sale_price;
        }

        public void setSale_price(Double sale_price) {
            this.sale_price = sale_price;
        }

        public Integer getSku_cnt() {
            return sku_cnt;
        }

        public void setSku_cnt(Integer sku_cnt) {
            this.sku_cnt = sku_cnt;
        }

        public Integer getOn_aftersale_sku_cnt() {
            return on_aftersale_sku_cnt;
        }

        public void setOn_aftersale_sku_cnt(Integer on_aftersale_sku_cnt) {
            this.on_aftersale_sku_cnt = on_aftersale_sku_cnt;
        }

        public Integer getFinish_aftersale_sku_cnt() {
            return finish_aftersale_sku_cnt;
        }

        public void setFinish_aftersale_sku_cnt(Integer finish_aftersale_sku_cnt) {
            this.finish_aftersale_sku_cnt = finish_aftersale_sku_cnt;
        }

        public List<SkuAttr> getSku_attrs() {
            return sku_attrs;
        }

        public void setSku_attrs(List<SkuAttr> sku_attrs) {
            this.sku_attrs = sku_attrs;
        }

    }

    private List<ProductInfo> product_infos;
    private PayInfo pay_info;
    private PriceInfo price_info;
    private DeliveryInfo delivery_info;

    public List<ProductInfo> getProduct_infos() {
        return product_infos;
    }

    public void setProduct_infos(List<ProductInfo> product_infos) {
        this.product_infos = product_infos;
    }

    public PayInfo getPay_info() {
        return pay_info;
    }

    public void setPay_info(PayInfo pay_info) {
        this.pay_info = pay_info;
    }

    public PriceInfo getPrice_info() {
        return price_info;
    }

    public void setPrice_info(PriceInfo price_info) {
        this.price_info = price_info;
    }

    public DeliveryInfo getDelivery_info() {
        return delivery_info;
    }

    public void setDelivery_info(DeliveryInfo delivery_info) {
        this.delivery_info = delivery_info;
    }

}