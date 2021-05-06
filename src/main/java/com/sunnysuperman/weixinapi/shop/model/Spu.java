package com.sunnysuperman.weixinapi.shop.model;

public class Spu extends AddSpuRequest {
    private Long product_id;
    private String create_time;
    private String update_time;
    private AuditInfo audit_info;
    private Integer status;
    private Integer edit_status;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEdit_status() {
        return edit_status;
    }

    public void setEdit_status(Integer edit_status) {
        this.edit_status = edit_status;
    }

}
