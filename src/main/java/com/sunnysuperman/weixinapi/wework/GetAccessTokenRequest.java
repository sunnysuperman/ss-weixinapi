package com.sunnysuperman.weixinapi.wework;

import com.sunnysuperman.weixinapi.WeixinApp;

public class GetAccessTokenRequest {

    private String suite_id;
    private String suite_secret;
    private String suite_ticket;

    public GetAccessTokenRequest() {
    }

    public GetAccessTokenRequest(WeixinApp app, String ticket) {
        this.suite_id = app.getAppId();
        this.suite_secret = app.getAppSecret();
        this.suite_ticket = ticket;
    }

    public String getSuite_id() {
        return suite_id;
    }

    public void setSuite_id(String suite_id) {
        this.suite_id = suite_id;
    }

    public String getSuite_secret() {
        return suite_secret;
    }

    public void setSuite_secret(String suite_secret) {
        this.suite_secret = suite_secret;
    }

    public String getSuite_ticket() {
        return suite_ticket;
    }

    public void setSuite_ticket(String suite_ticket) {
        this.suite_ticket = suite_ticket;
    }
}
