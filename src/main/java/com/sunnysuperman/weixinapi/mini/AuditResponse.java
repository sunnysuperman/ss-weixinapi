package com.sunnysuperman.weixinapi.mini;

import com.sunnysuperman.weixinapi.BaseResponse;

public class AuditResponse extends BaseResponse {
    private String auditid;
    private int status;
    private String reason;

    public String getAuditid() {
        return auditid;
    }

    public void setAuditid(String auditid) {
        this.auditid = auditid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
