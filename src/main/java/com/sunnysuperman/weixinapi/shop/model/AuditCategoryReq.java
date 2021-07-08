package com.sunnysuperman.weixinapi.shop.model;

public class AuditCategoryReq {

    private String license;
    private CategoryInfo category_info;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public CategoryInfo getCategory_info() {
        return category_info;
    }

    public void setCategory_info(CategoryInfo category_info) {
        this.category_info = category_info;
    }
}
