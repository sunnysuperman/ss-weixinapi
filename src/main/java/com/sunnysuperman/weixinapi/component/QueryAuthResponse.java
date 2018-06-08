package com.sunnysuperman.weixinapi.component;

public class QueryAuthResponse {
    private AuthorizerToken authorization_info;
    private AuthorizationFunction[] func_info;

    public AuthorizerToken getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(AuthorizerToken authorization_info) {
        this.authorization_info = authorization_info;
    }

    public AuthorizationFunction[] getFunc_info() {
        return func_info;
    }

    public void setFunc_info(AuthorizationFunction[] func_info) {
        this.func_info = func_info;
    }

}
