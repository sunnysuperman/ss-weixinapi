package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class GetSpuListResponse {
    private int total_num;
    private List<Spu> spus;

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public List<Spu> getSpus() {
        return spus;
    }

    public void setSpus(List<Spu> spus) {
        this.spus = spus;
    }

}
