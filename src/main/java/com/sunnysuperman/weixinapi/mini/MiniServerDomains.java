package com.sunnysuperman.weixinapi.mini;

public class MiniServerDomains {
    private String[] requestdomain;
    private String[] wsrequestdomain;
    private String[] uploaddomain;
    private String[] downloaddomain;

    public String[] getRequestdomain() {
        return requestdomain;
    }

    public void setRequestdomain(String[] requestdomain) {
        this.requestdomain = requestdomain;
    }

    public String[] getWsrequestdomain() {
        return wsrequestdomain;
    }

    public void setWsrequestdomain(String[] wsrequestdomain) {
        this.wsrequestdomain = wsrequestdomain;
    }

    public String[] getUploaddomain() {
        return uploaddomain;
    }

    public void setUploaddomain(String[] uploaddomain) {
        this.uploaddomain = uploaddomain;
    }

    public String[] getDownloaddomain() {
        return downloaddomain;
    }

    public void setDownloaddomain(String[] downloaddomain) {
        this.downloaddomain = downloaddomain;
    }

}
