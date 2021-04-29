package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class AddSpuRequest {
    private String out_product_id;
    private String title;
    private String path;
    private List<String> head_img;
    private List<String> qualification_pics;
    private SpuDescInfo desc_info;
    private Integer third_cat_id;
    private Integer brand_id;
    private String info_version;
    private List<Sku> skus;

    public String getOut_product_id() {
        return out_product_id;
    }

    public void setOut_product_id(String out_product_id) {
        this.out_product_id = out_product_id;
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

    public List<String> getHead_img() {
        return head_img;
    }

    public void setHead_img(List<String> head_img) {
        this.head_img = head_img;
    }

    public List<String> getQualification_pics() {
        return qualification_pics;
    }

    public void setQualification_pics(List<String> qualification_pics) {
        this.qualification_pics = qualification_pics;
    }

    public SpuDescInfo getDesc_info() {
        return desc_info;
    }

    public void setDesc_info(SpuDescInfo desc_info) {
        this.desc_info = desc_info;
    }

    public Integer getThird_cat_id() {
        return third_cat_id;
    }

    public void setThird_cat_id(Integer third_cat_id) {
        this.third_cat_id = third_cat_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getInfo_version() {
        return info_version;
    }

    public void setInfo_version(String info_version) {
        this.info_version = info_version;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

}
