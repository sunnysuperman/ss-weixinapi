package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetCompanyListResponse {

    List<Company> company_list;

    public static class Company {

        private String delivery_id;
        private String delivery_name;

        public String getDelivery_id() {
            return delivery_id;
        }

        public void setDelivery_id(String delivery_id) {
            this.delivery_id = delivery_id;
        }

        public String getDelivery_name() {
            return delivery_name;
        }

        public void setDelivery_name(String delivery_name) {
            this.delivery_name = delivery_name;
        }
    }

    public List<Company> getCompany_list() {
        return company_list;
    }

    public void setCompany_list(List<Company> company_list) {
        this.company_list = company_list;
    }
}
