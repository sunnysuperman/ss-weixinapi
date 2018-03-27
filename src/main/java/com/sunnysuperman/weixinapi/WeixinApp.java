package com.sunnysuperman.weixinapi;

public class WeixinApp {
    private String appId;
    private String appSecret;
    private WeixinAppType appType;
    private String appToken;
    private String appAesKey;

    public WeixinApp(String appId, String appSecret, WeixinAppType appType) {
        super();
        this.appId = appId;
        this.appSecret = appSecret;
        this.appType = appType;
    }

    public WeixinApp(String appId, String appSecret, WeixinAppType appType, String appToken, String appAesKey) {
        super();
        this.appId = appId;
        this.appSecret = appSecret;
        this.appType = appType;
        this.appToken = appToken;
        this.appAesKey = appAesKey;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public WeixinAppType getAppType() {
        return appType;
    }

    public String getAppToken() {
        return appToken;
    }

    public String getAppAesKey() {
        return appAesKey;
    }

}
