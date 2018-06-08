package com.sunnysuperman.weixinapi.component;

public class AuthorizationFunction {
    public static class AuthorizationFunctionScope {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    private AuthorizationFunctionScope funcscope_category;

    public AuthorizationFunction.AuthorizationFunctionScope getFuncscope_category() {
        return funcscope_category;
    }

    public void setFuncscope_category(AuthorizationFunction.AuthorizationFunctionScope funcscope_category) {
        this.funcscope_category = funcscope_category;
    }

}