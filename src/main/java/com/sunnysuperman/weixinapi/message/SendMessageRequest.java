package com.sunnysuperman.weixinapi.message;

import java.util.Map;

public class SendMessageRequest {
    private String touser;
    private String template_id;
    private String url;
    private Map<String, Object> data;
    private Map<String, Object> miniprogram;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(Map<String, Object> miniprogram) {
        this.miniprogram = miniprogram;
    }

}
