package com.sunnysuperman.weixinapi.media;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.sunnysuperman.commons.util.FileUtil;
import com.sunnysuperman.commons.util.StringUtil;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeixinMediaApi extends TokenAwareWeixinApi {

    public WeixinMediaApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public WeixinMediaApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
    }

    @Override
    protected String wrapApiUrl(String api) {
        return "http://file.api.weixin.qq.com/cgi-bin/media/get";
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
                urlBuf.append(entry.getKey()).append('=')
                        .append(URLEncoder.encode(entry.getValue().toString(), StringUtil.UTF8));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        String getUrl = urlBuf.toString();
        return getUrl;
    }

    private Request getRequestBuilder(String url, Map<String, Object> params, Map<String, Object> headers) {
        Request.Builder builder = new Request.Builder().url(getUrl(url, params));
        if (headers != null) {
            for (Entry<String, Object> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        return builder.build();
    }

    public boolean download(String mediaId, OutputStream out, int timeoutInSecond) throws Exception {
        String accessToken = ensureAccessToken();

        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("media_id", mediaId);
        Request request = getRequestBuilder("http://file.api.weixin.qq.com/cgi-bin/media/get", params, null);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(timeoutInSecond, TimeUnit.SECONDS).build();
        Response response = client.newCall(request).execute();
        InputStream in = null;
        try {
            String contentType = response.header("Content-Type");
            if (contentType.indexOf("audio") < 0) {
                return false;
            }
            in = response.body().byteStream();
            copy(in, out, new byte[4096]);
            boolean ok = response.isSuccessful();
            if (!ok) {
                return false;
            }
            return true;
        } finally {
            FileUtil.close(in);
            FileUtil.close(out);
        }
    }

    private static long copy(InputStream input, OutputStream output, byte[] buffer) throws IOException {
        long count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

}
