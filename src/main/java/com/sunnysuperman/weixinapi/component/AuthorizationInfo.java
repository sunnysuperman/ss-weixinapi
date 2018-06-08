package com.sunnysuperman.weixinapi.component;

public class AuthorizationInfo {
    private String authorization_appid;
    private AuthorizationFunction[] func_info;

    public String getAuthorization_appid() {
        return authorization_appid;
    }

    public void setAuthorization_appid(String authorization_appid) {
        this.authorization_appid = authorization_appid;
    }

    public AuthorizationFunction[] getFunc_info() {
        return func_info;
    }

    public void setFunc_info(AuthorizationFunction[] func_info) {
        this.func_info = func_info;
    }

}
