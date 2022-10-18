package com.sunnysuperman.weixinapi.component;

public class WxshopAftersaleUpdateResponse {

    private String msgType;
    private String createTime;
    private String event;
    private AftersaleInfo aftersale_info;

    public static class AftersaleInfo {

        private String aftersale_id;
        private String out_aftersale_id;

        public String getAftersale_id() {
            return aftersale_id;
        }

        public void setAftersale_id(String aftersale_id) {
            this.aftersale_id = aftersale_id;
        }

        public String getOut_aftersale_id() {
            return out_aftersale_id;
        }

        public void setOut_aftersale_id(String out_aftersale_id) {
            this.out_aftersale_id = out_aftersale_id;
        }
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public AftersaleInfo getAftersale_info() {
        return aftersale_info;
    }

    public void setAftersale_info(AftersaleInfo aftersale_info) {
        this.aftersale_info = aftersale_info;
    }
}
