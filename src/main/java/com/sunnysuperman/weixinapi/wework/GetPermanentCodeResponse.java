package com.sunnysuperman.weixinapi.wework;

public class GetPermanentCodeResponse {

    public static class AuthCorpInfo {
        private String corpid;
        private String corp_name;
        private String corp_full_name;
        private String corp_wxqrcode;

        public String getCorpid() {
            return corpid;
        }

        public void setCorpid(String corpid) {
            this.corpid = corpid;
        }

        public String getCorp_name() {
            return corp_name;
        }

        public void setCorp_name(String corp_name) {
            this.corp_name = corp_name;
        }
    }

    private String permanent_code;
    private String access_token;
    private AuthCorpInfo auth_corp_info;

    public String getPermanent_code() {
        return permanent_code;
    }

    public void setPermanent_code(String permanent_code) {
        this.permanent_code = permanent_code;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public AuthCorpInfo getAuth_corp_info() {
        return auth_corp_info;
    }

    public void setAuth_corp_info(AuthCorpInfo auth_corp_info) {
        this.auth_corp_info = auth_corp_info;
    }
}
