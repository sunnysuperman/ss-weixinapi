package com.sunnysuperman.weixinapi.user;

import java.util.List;

public class GetUsersResponse {
    public static class GetUsersResponseData {
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }

    }

    private int total;
    private int count;
    private GetUsersResponseData data;
    private String next_openid;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GetUsersResponseData getData() {
        return data;
    }

    public void setData(GetUsersResponseData data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

}
