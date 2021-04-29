package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetShopCategoryListResponse {

    public static class ShopCategory {
        private Integer third_cat_id;
        private String third_cat_name;
        private Integer second_cat_id;
        private String second_cat_name;
        private Integer first_cat_id;
        private String first_cat_name;

        public Integer getThird_cat_id() {
            return third_cat_id;
        }

        public void setThird_cat_id(Integer third_cat_id) {
            this.third_cat_id = third_cat_id;
        }

        public String getThird_cat_name() {
            return third_cat_name;
        }

        public void setThird_cat_name(String third_cat_name) {
            this.third_cat_name = third_cat_name;
        }

        public Integer getSecond_cat_id() {
            return second_cat_id;
        }

        public void setSecond_cat_id(Integer second_cat_id) {
            this.second_cat_id = second_cat_id;
        }

        public String getSecond_cat_name() {
            return second_cat_name;
        }

        public void setSecond_cat_name(String second_cat_name) {
            this.second_cat_name = second_cat_name;
        }

        public Integer getFirst_cat_id() {
            return first_cat_id;
        }

        public void setFirst_cat_id(Integer first_cat_id) {
            this.first_cat_id = first_cat_id;
        }

        public String getFirst_cat_name() {
            return first_cat_name;
        }

        public void setFirst_cat_name(String first_cat_name) {
            this.first_cat_name = first_cat_name;
        }

    }

    private List<ShopCategory> data;

    public List<ShopCategory> getData() {
        return data;
    }

    public void setData(List<ShopCategory> data) {
        this.data = data;
    }

}
