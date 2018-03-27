package com.sunnysuperman.weixinapi.component;

public class QueryAuthResponse {
    public static class AuthFunctionScope {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static class AuthFunction {
        private AuthFunctionScope funcscope_category;

        public AuthFunctionScope getFuncscope_category() {
            return funcscope_category;
        }

        public void setFuncscope_category(AuthFunctionScope funcscope_category) {
            this.funcscope_category = funcscope_category;
        }

    }

    private AuthorizerToken authorization_info;
    private AuthFunction[] func_info;

    public AuthorizerToken getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(AuthorizerToken authorization_info) {
        this.authorization_info = authorization_info;
    }

    public AuthFunction[] getFunc_info() {
        return func_info;
    }

    public void setFunc_info(AuthFunction[] func_info) {
        this.func_info = func_info;
    }

}
