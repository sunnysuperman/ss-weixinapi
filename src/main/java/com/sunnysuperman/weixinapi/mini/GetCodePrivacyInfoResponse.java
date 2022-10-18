package com.sunnysuperman.weixinapi.mini;

public class GetCodePrivacyInfoResponse {

    private String[] without_auth_list;
    private String[] without_conf_list;

    public String[] getWithout_auth_list() {
        return without_auth_list;
    }

    public void setWithout_auth_list(String[] without_auth_list) {
        this.without_auth_list = without_auth_list;
    }

    public String[] getWithout_conf_list() {
        return without_conf_list;
    }

    public void setWithout_conf_list(String[] without_conf_list) {
        this.without_conf_list = without_conf_list;
    }
}
