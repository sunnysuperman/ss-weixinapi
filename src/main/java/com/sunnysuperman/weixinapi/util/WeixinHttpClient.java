package com.sunnysuperman.weixinapi.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.sunnysuperman.commons.util.StringUtil;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WeixinHttpClient {
    private int connectTimeout = 20;
    private int readTimeout = 30;
    private int responseCode;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public WeixinHttpClient setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public WeixinHttpClient setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public int getResponseCode() {
        return responseCode;
    }

    private String getUrl(String url, Map<String, Object> params) {
        if (params == null) {
            return url;
        }
        StringBuilder urlBuf = new StringBuilder(url);
        boolean appendQuestionMark = url.indexOf('?') < 0;
        for (Entry<String, Object> entry : params.entrySet()) {
            if (appendQuestionMark) {
                urlBuf.append('?');
                appendQuestionMark = false;
            } else {
                urlBuf.append('&');
            }
            try {
                Object value = entry.getValue();
                urlBuf.append(entry.getKey()).append('=');
                if (value != null) {
                    urlBuf.append(URLEncoder.encode(value.toString(), StringUtil.UTF8));
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        String getUrl = urlBuf.toString();
        return getUrl;
    }

    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS).build();
        return client;
    }

    private String execute(Request request) throws IOException {
        Response response = getClient().newCall(request).execute();
        responseCode = response.code();
        return response.body().string();
    }

    private Request.Builder requestBuilder(String url, Map<String, Object> params, Map<String, Object> headers) {
        Request.Builder builder = new Request.Builder().url(getUrl(url, params));
        if (headers != null) {
            for (Entry<String, Object> entry : headers.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                builder.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        return builder;
    }

    public String get(String url, Map<String, Object> params, Map<String, Object> headers) throws IOException {
        Request.Builder reqBuilder = requestBuilder(url, params, headers);
        Request request = reqBuilder.build();
        return execute(request);
    }

    public String post(String url, Map<String, Object> params, Map<String, Object> headers) throws IOException {
        Request.Builder reqBuilder = requestBuilder(url, null, headers);
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                bodyBuilder.add(entry.getKey(), entry.getValue().toString());
            }
        }
        Request request = reqBuilder.post(bodyBuilder.build()).build();
        return execute(request);
    }

    public String post(String url, String mediaType, String body, Map<String, Object> headers) throws IOException {
        Request.Builder reqBuilder = requestBuilder(url, null, headers);
        RequestBody reqBody = RequestBody.create(MediaType.parse(mediaType), body);
        Request request = reqBuilder.post(reqBody).build();
        return execute(request);
    }

}
