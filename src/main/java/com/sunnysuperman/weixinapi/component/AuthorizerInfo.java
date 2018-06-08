package com.sunnysuperman.weixinapi.component;

import java.util.List;

public class AuthorizerInfo {
    public static class ServiceTypeInfo {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static class BusinessInfo {
        private byte open_store;
        private byte open_scan;
        private byte open_pay;
        private byte open_card;
        private byte open_shake;

        public byte getOpen_store() {
            return open_store;
        }

        public void setOpen_store(byte open_store) {
            this.open_store = open_store;
        }

        public byte getOpen_scan() {
            return open_scan;
        }

        public void setOpen_scan(byte open_scan) {
            this.open_scan = open_scan;
        }

        public byte getOpen_pay() {
            return open_pay;
        }

        public void setOpen_pay(byte open_pay) {
            this.open_pay = open_pay;
        }

        public byte getOpen_card() {
            return open_card;
        }

        public void setOpen_card(byte open_card) {
            this.open_card = open_card;
        }

        public byte getOpen_shake() {
            return open_shake;
        }

        public void setOpen_shake(byte open_shake) {
            this.open_shake = open_shake;
        }

    }

    public static class MiniProgramInfoNetwork {
        private List<String> requestDomain;
        private List<String> wsRequestDomain;
        private List<String> uploadDomain;
        private List<String> downloadDomain;

        public List<String> getRequestDomain() {
            return requestDomain;
        }

        public void setRequestDomain(List<String> requestDomain) {
            this.requestDomain = requestDomain;
        }

        public List<String> getWsRequestDomain() {
            return wsRequestDomain;
        }

        public void setWsRequestDomain(List<String> wsRequestDomain) {
            this.wsRequestDomain = wsRequestDomain;
        }

        public List<String> getUploadDomain() {
            return uploadDomain;
        }

        public void setUploadDomain(List<String> uploadDomain) {
            this.uploadDomain = uploadDomain;
        }

        public List<String> getDownloadDomain() {
            return downloadDomain;
        }

        public void setDownloadDomain(List<String> downloadDomain) {
            this.downloadDomain = downloadDomain;
        }

    }

    public static class MiniProgramCategory {
        private String first;
        private String second;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }

    }

    public static class MiniProgramInfo {
        private MiniProgramInfoNetwork network;
        private List<MiniProgramCategory> categories;
        private int visit_status;

        public MiniProgramInfoNetwork getNetwork() {
            return network;
        }

        public void setNetwork(MiniProgramInfoNetwork network) {
            this.network = network;
        }

        public List<MiniProgramCategory> getCategories() {
            return categories;
        }

        public void setCategories(List<MiniProgramCategory> categories) {
            this.categories = categories;
        }

        public int getVisit_status() {
            return visit_status;
        }

        public void setVisit_status(int visit_status) {
            this.visit_status = visit_status;
        }

    }

    private String nick_name;
    private String head_img;
    private ServiceTypeInfo service_type_info;
    private ServiceTypeInfo verify_type_info;
    private String user_name;
    private String principal_name;
    private BusinessInfo business_info;
    private String alias;
    private String qrcode_url;
    private MiniProgramInfo miniProgramInfo;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public ServiceTypeInfo getService_type_info() {
        return service_type_info;
    }

    public void setService_type_info(ServiceTypeInfo service_type_info) {
        this.service_type_info = service_type_info;
    }

    public ServiceTypeInfo getVerify_type_info() {
        return verify_type_info;
    }

    public void setVerify_type_info(ServiceTypeInfo verify_type_info) {
        this.verify_type_info = verify_type_info;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPrincipal_name() {
        return principal_name;
    }

    public void setPrincipal_name(String principal_name) {
        this.principal_name = principal_name;
    }

    public BusinessInfo getBusiness_info() {
        return business_info;
    }

    public void setBusiness_info(BusinessInfo business_info) {
        this.business_info = business_info;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getQrcode_url() {
        return qrcode_url;
    }

    public void setQrcode_url(String qrcode_url) {
        this.qrcode_url = qrcode_url;
    }

    public MiniProgramInfo getMiniProgramInfo() {
        return miniProgramInfo;
    }

    public void setMiniProgramInfo(MiniProgramInfo miniProgramInfo) {
        this.miniProgramInfo = miniProgramInfo;
    }

}
