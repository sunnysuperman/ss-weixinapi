package com.sunnysuperman.weixinapi.shop.model;

import com.sunnysuperman.commons.util.StringUtil;

public class GetSpuListRequest {
    private String start_create_time = StringUtil.EMPTY;
    private String end_create_time = StringUtil.EMPTY;
    private String start_update_time = StringUtil.EMPTY;
    private String end_update_time = StringUtil.EMPTY;
    private Integer status;
    private int page = 1;
    private int page_size = 10;
    private int need_edit_spu;

    public String getStart_create_time() {
        return start_create_time;
    }

    public void setStart_create_time(String start_create_time) {
        this.start_create_time = start_create_time;
    }

    public String getEnd_create_time() {
        return end_create_time;
    }

    public void setEnd_create_time(String end_create_time) {
        this.end_create_time = end_create_time;
    }

    public String getStart_update_time() {
        return start_update_time;
    }

    public void setStart_update_time(String start_update_time) {
        this.start_update_time = start_update_time;
    }

    public String getEnd_update_time() {
        return end_update_time;
    }

    public void setEnd_update_time(String end_update_time) {
        this.end_update_time = end_update_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getNeed_edit_spu() {
        return need_edit_spu;
    }

    public void setNeed_edit_spu(int need_edit_spu) {
        this.need_edit_spu = need_edit_spu;
    }

}
