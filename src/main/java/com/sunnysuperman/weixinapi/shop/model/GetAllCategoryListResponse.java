package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetAllCategoryListResponse {

    public static class ThirdCategory {
        private Integer third_cat_id;
        private String third_cat_name;
        private String qualification;
        private String qualification_type;
        private String product_qualification;
        private String product_qualification_type;
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

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getQualification_type() {
            return qualification_type;
        }

        public void setQualification_type(String qualification_type) {
            this.qualification_type = qualification_type;
        }

        public String getProduct_qualification() {
            return product_qualification;
        }

        public void setProduct_qualification(String product_qualification) {
            this.product_qualification = product_qualification;
        }

        public String getProduct_qualification_type() {
            return product_qualification_type;
        }

        public void setProduct_qualification_type(String product_qualification_type) {
            this.product_qualification_type = product_qualification_type;
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

    private List<ThirdCategory> third_cat_list;

    public List<ThirdCategory> getThird_cat_list() {
        return third_cat_list;
    }

    public void setThird_cat_list(List<ThirdCategory> third_cat_list) {
        this.third_cat_list = third_cat_list;
    }

}
