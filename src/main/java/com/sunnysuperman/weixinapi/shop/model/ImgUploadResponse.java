package com.sunnysuperman.weixinapi.shop.model;

public class ImgUploadResponse {

    private Integer errcode;
    private String errmsg;
    private ImgInfo img_info;

    public boolean ok() {
        return this.errcode == 0;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public ImgInfo getImg_info() {
        return img_info;
    }

    public void setImg_info(ImgInfo img_info) {
        this.img_info = img_info;
    }
}
