package com.sunnysuperman.weixinapi.shop.model;

public class Spu extends AddSpuRequest {
    private long product_id;
    private String create_time;
    private String update_time;
    private AuditInfo audit_info;
    private byte status;
    private byte edit_status;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public AuditInfo getAudit_info() {
        return audit_info;
    }

    public void setAudit_info(AuditInfo audit_info) {
        this.audit_info = audit_info;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getEdit_status() {
        return edit_status;
    }

    public void setEdit_status(byte edit_status) {
        this.edit_status = edit_status;
    }

}
