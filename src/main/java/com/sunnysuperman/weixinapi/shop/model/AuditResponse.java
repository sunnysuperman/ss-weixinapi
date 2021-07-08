package com.sunnysuperman.weixinapi.shop.model;

import com.sunnysuperman.weixinapi.BaseResponse;

public class AuditResponse extends BaseResponse {

    private String audit_id;

    public String getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(String audit_id) {
        this.audit_id = audit_id;
    }
}
