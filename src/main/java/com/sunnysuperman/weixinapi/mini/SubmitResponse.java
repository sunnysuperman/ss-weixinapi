package com.sunnysuperman.weixinapi.mini;

import com.sunnysuperman.weixinapi.BaseResponse;

public class SubmitResponse extends BaseResponse {
    private String auditid;

    public String getAuditid() {
        return auditid;
    }

    public void setAuditid(String auditid) {
        this.auditid = auditid;
    }

}
