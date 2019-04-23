package com.sunnysuperman.weixinapi.mini;

import com.sunnysuperman.weixinapi.BaseResponse;

public class GetAuditStatusResponse extends BaseResponse {
    private String auditid;
    private byte status;
    private String reason;

    public String getAuditid() {
        return auditid;
    }

    public void setAuditid(String auditid) {
        this.auditid = auditid;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
