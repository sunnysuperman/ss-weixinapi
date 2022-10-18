package com.sunnysuperman.weixinapi.shop.model;

//https://developers.weixin.qq.com/miniprogram/dev/platform-capabilities/business-capabilities/ministore/minishopopencomponent2/API/account/update_info.html
public class CustomerServiceAccount {

    private String service_agent_path;
    private String service_agent_phone;
    private Integer[] service_agent_type;
    private Address default_receiving_address;

    public static class Address {
        private String receiver_name;
        private String detailed_address;
        private String tel_number;
        private String country;
        private String province;
        private String city;
        private String town;

        public String getReceiver_name() {
            return receiver_name;
        }

        public void setReceiver_name(String receiver_name) {
            this.receiver_name = receiver_name;
        }

        public String getDetailed_address() {
            return detailed_address;
        }

        public void setDetailed_address(String detailed_address) {
            this.detailed_address = detailed_address;
        }

        public String getTel_number() {
            return tel_number;
        }

        public void setTel_number(String tel_number) {
            this.tel_number = tel_number;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }

    public String getService_agent_path() {
        return service_agent_path;
    }

    public void setService_agent_path(String service_agent_path) {
        this.service_agent_path = service_agent_path;
    }

    public String getService_agent_phone() {
        return service_agent_phone;
    }

    public void setService_agent_phone(String service_agent_phone) {
        this.service_agent_phone = service_agent_phone;
    }

    public Integer[] getService_agent_type() {
        return service_agent_type;
    }

    public void setService_agent_type(Integer[] service_agent_type) {
        this.service_agent_type = service_agent_type;
    }

    public Address getDefault_receiving_address() {
        return default_receiving_address;
    }

    public void setDefault_receiving_address(Address default_receiving_address) {
        this.default_receiving_address = default_receiving_address;
    }
}
