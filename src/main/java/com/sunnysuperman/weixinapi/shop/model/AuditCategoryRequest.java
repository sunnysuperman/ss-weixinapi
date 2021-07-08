package com.sunnysuperman.weixinapi.shop.model;

public class AuditCategoryRequest {

    private AuditCategoryReq audit_req;

    public AuditCategoryRequest() {
        super();
    }

    public AuditCategoryRequest(AuditCategoryReq audit_req) {
        super();
        this.audit_req = audit_req;
    }

    public AuditCategoryReq getAudit_req() {
        return audit_req;
    }

    public void setAudit_req(AuditCategoryReq audit_req) {
        this.audit_req = audit_req;
    }
}
