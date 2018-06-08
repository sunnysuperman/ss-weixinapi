package com.sunnysuperman.weixinapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.FormatUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.util.WeixinHttpClient;
import com.sunnysuperman.weixinapi.util.WeixinJSONHelper;

public class WeixinApi {
    private static final Logger LOG = LoggerFactory.getLogger(WeixinApi.class);
    protected WeixinApp app;

    public WeixinApi(WeixinApp app) {
        super();
        this.app = app;
    }

    public WeixinApp getApp() {
        return app;
    }

    protected WeixinApiException wrapIOException(IOException e) throws WeixinApiException {
        return new WeixinApiException(e, -1, "Failed to call weixin api");
    }

    protected <T> T parseResult(String apiUrl, String responseBody, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        Map<String, Object> result = JSONUtil.parseJSONObject(responseBody);
        if (result == null) {
            throw new WeixinApiException(-1, "Failed to parse weixin api result: " + responseBody);
        }
        Integer errcode = FormatUtil.parseInteger(result.get("errcode"));
        if (errcode != null && errcode != 0) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("[WeixinApi] Failed to call " + apiUrl + ", result: " + responseBody);
            }
            String errmsg = FormatUtil.parseString(result.get("errmsg"));
            throw new WeixinApiException(errcode, errmsg);
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("[WeixinApi] call " + apiUrl + ", result: " + responseBody);
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

    protected String wrapApiUrl(String api) {
        return "https://api.weixin.qq.com/" + api;
    }

    protected <T> T request(boolean get, String api, Map<String, Object> params, T bean, boolean camelizeJSON)
            throws WeixinApiException {
        WeixinHttpClient client = new WeixinHttpClient();
        String apiUrl = wrapApiUrl(api);
        String responseBody;
        try {
            if (get) {
                responseBody = client.get(apiUrl, params, null);
            } else {
                responseBody = client.post(apiUrl, params, null);
            }
        } catch (IOException e) {
            throw wrapIOException(e);
        }
        return parseResult(apiUrl, responseBody, bean, camelizeJSON);
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
        WeixinHttpClient client = new WeixinHttpClient();
        String apiUrl = wrapApiUrl(api);
        String requestBody = JSONUtil.toJSONString(params);
        String responseBody;
        try {
            responseBody = client.post(apiUrl, "application/json; charset=UTF-8", requestBody, null);
        } catch (IOException e) {
            throw wrapIOException(e);
        }
        return parseResult(apiUrl, responseBody, bean, camelizeJSON);
    }

    protected <T> T postJSON(String api, Object params, T bean) throws WeixinApiException {
        return postJSON(api, params, bean, false);
    }
}
