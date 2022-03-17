package com.sunnysuperman.weixinapi.wework;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;

public abstract class TokenAwareWeworkApi extends TokenAwareWeixinApi {

    public TokenAwareWeworkApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public TokenAwareWeworkApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
    }

    @Override
    protected String wrapApiUrl(String api, Map<String, Object> params) {
        StringBuilder buf = new StringBuilder("https://qyapi.weixin.qq.com/").append(api);
        if (params == null || params.isEmpty()) {
            return buf.toString();
        }
        boolean appendQuestionMark = api.indexOf('?') < 0;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
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

}
