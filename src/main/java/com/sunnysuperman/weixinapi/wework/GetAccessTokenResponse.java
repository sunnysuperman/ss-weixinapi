package com.sunnysuperman.weixinapi.wework;

public class GetAccessTokenResponse {

    private String suite_access_token;
    private int expires_in;

    public String getSuite_access_token() {
        return suite_access_token;
    }

    public void setSuite_access_token(String suite_access_token) {
        this.suite_access_token = suite_access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
