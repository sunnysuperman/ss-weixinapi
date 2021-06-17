package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class AddAftersaleRequest {
    private String out_order_id;
    private String out_aftersale_id;
    private String openid;
    private Integer type;
    private String create_time;
    private Integer status;
    private Integer finish_all_aftersale;
    private String path;
    private List<ProductInfo> product_infos;

    public String getOut_order_id() {
        return out_order_id;
    }

    public void setOut_order_id(String out_order_id) {
        this.out_order_id = out_order_id;
    }

    public String getOut_aftersale_id() {
        return out_aftersale_id;
    }

    public void setOut_aftersale_id(String out_aftersale_id) {
        this.out_aftersale_id = out_aftersale_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFinish_all_aftersale() {
        return finish_all_aftersale;
    }

    public void setFinish_all_aftersale(Integer finish_all_aftersale) {
        this.finish_all_aftersale = finish_all_aftersale;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ProductInfo> getProduct_infos() {
        return product_infos;
    }

    public void setProduct_infos(List<ProductInfo> product_infos) {
        this.product_infos = product_infos;
    }

}
