package com.sunnysuperman.weixinapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.FormatUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.http.client.HttpTextResult;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.exception.WeixinNetworkException;
import com.sunnysuperman.weixinapi.util.WeixinJSONHelper;

public class WeixinApi {
    protected static final Logger LOG = LoggerFactory.getLogger(WeixinApi.class);
    protected WeixinApp app;
    protected HttpClientFactory httpClientFactory;

    public WeixinApi(WeixinApp app, HttpClientFactory httpClientFactory) {
        super();
        this.app = app;
        this.httpClientFactory = httpClientFactory != null ? httpClientFactory : DefaultHttpClientFactory.getInstance();
    }

    public WeixinApi(WeixinApp app) {
        this(app, null);
    }

    public WeixinApp getApp() {
        return app;
    }

    protected WeixinApiException wrapIOException(IOException e) throws WeixinApiException {
        return new WeixinNetworkException(e);
    }

    protected <T> T parseResult(String apiUrl, String responseBody, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        if (LOG.isInfoEnabled()) {
            LOG.info("[WeixinApi] call " + apiUrl + ", result: " + responseBody);
        }
        Map<String, Object> result = JSONUtil.parseJSONObject(responseBody);
        if (result == null) {
            throw new WeixinNetworkException("Failed to parse weixin api result: " + responseBody);
        }
        Integer errcode = FormatUtil.parseInteger(result.get("errcode"));
        if (errcode != null && errcode != 0) {
            String errmsg = FormatUtil.parseString(result.get("errmsg"));
            throw new WeixinApiException(errcode, errmsg);
        }
        if (camelizeJSON) {
            return WeixinJSONHelper.fromMap(result, bean);
        }
        return Bean.fromMap(result, bean);
    }

    private static Object toWechatJSONValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Map<?, ?> subObject = (Map<?, ?>) value;
            return toWechatJSON(subObject);
        } else if (value instanceof List) {
            List<?> subList = (List<?>) value;
            List<Object> items = new ArrayList<>(subList.size());
            for (Object subObject : subList) {
                items.add(toWechatJSONValue(subObject));
            }
            return items;
        } else {
            return value;
        }
    }

    private static Map<String, Object> toWechatJSON(Map<?, ?> json) {
        Map<String, Object> replace = new HashMap<>();
        for (Entry<?, ?> entry : json.entrySet()) {
            String key = entry.getKey().toString();
            char c = key.charAt(0);
            if (c >= 97 || c <= 122) {
                key = Character.toUpperCase(c) + key.substring(1);
            }
            Object value = entry.getValue();
            replace.put(key, toWechatJSONValue(value));
        }
        return replace;
    }

    protected String wrapApiUrl(String api, Map<String, Object> params) {
        StringBuilder buf = new StringBuilder("https://api.weixin.qq.com/").append(api);
        if (params == null || params.isEmpty()) {
            return buf.toString();
        }
        boolean appendQuestionMark = api.indexOf('?') < 0;
        for (Entry<String, Object> entry : params.entrySet()) {
            if (appendQuestionMark) {
                buf.append('?');
                appendQuestionMark = false;
            } else {
                buf.append('&');
            }
            try {
                Object value = entry.getValue();
                buf.append(entry.getKey()).append('=');
                if (value != null) {
                    buf.append(URLEncoder.encode(value.toString(), StringUtil.UTF8));
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return buf.toString();
    }

    protected String wrapApiUrl(String api) {
        return wrapApiUrl(api, null);
    }

    protected <T> T request(boolean get, String api, Map<String, Object> params, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        String apiUrl = wrapApiUrl(api);
        HttpTextResult result;
        try {
            if (get) {
                result = httpClientFactory.getHttpClient().get(apiUrl, params, null);
            } else {
                result = httpClientFactory.getHttpClient().post(apiUrl, params, null);
            }
        } catch (IOException e) {
            throw wrapIOException(e);
        }
        if (!result.ok()) {
            throw new WeixinNetworkException("response http-code: " + result.getCode());
        }
        return parseResult(apiUrl, result.getBody(), bean, camelizeJSON);
    }

    protected <T> T get(String api, Map<String, Object> params, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        return request(true, api, params, bean, camelizeJSON);
    }

    protected <T> T get(String api, Map<String, Object> params, T bean) throws WeixinApiException {
        return request(true, api, params, bean, false);
    }

    protected <T> T post(String api, Map<String, Object> params, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        return request(false, api, params, bean, camelizeJSON);
    }

    protected <T> T post(String api, Map<String, Object> params, T bean) throws WeixinApiException {
        return request(false, api, params, bean, false);
    }

    protected <T> T postJSON(String api, Object params, T bean, boolean camelizeJSON) throws WeixinApiException {
        String apiUrl = wrapApiUrl(api);
        String requestBody = params == null ? null
                : JSONUtil.toJSONString(params, null, SerializerFeature.DisableCircularReferenceDetect);
        HttpTextResult result;
        try {
            result = httpClientFactory.getHttpClient().postJSON(apiUrl, requestBody, null);
        } catch (IOException e) {
            throw wrapIOException(e);
        }
        if (!result.ok()) {
            throw new WeixinNetworkException("response http-code: " + result.getCode());
        }
        return parseResult(apiUrl, result.getBody(), bean, camelizeJSON);
    }

    protected <T> T postJSON(String api, Object params, T bean) throws WeixinApiException {
        return postJSON(api, params, bean, false);
    }

    protected <T> T postMultipart(String api, Map<String, Object> data, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        String apiUrl = wrapApiUrl(api);
        HttpTextResult result;
        try {
            result = httpClientFactory.getHttpClient().postMultipart(apiUrl, data, null);
        } catch (IOException e) {
            throw wrapIOException(e);
        }
        if (!result.ok()) {
            throw new WeixinNetworkException("response http-code: " + result.getCode());
        }
        return parseResult(apiUrl, result.getBody(), bean, camelizeJSON);
    }
}
