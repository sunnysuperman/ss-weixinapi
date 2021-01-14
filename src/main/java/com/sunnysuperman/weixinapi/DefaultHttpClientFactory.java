package com.sunnysuperman.weixinapi;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunnysuperman.http.client.HttpClient;

import okhttp3.ConnectionPool;

public class DefaultHttpClientFactory implements HttpClientFactory {
    private static final DefaultHttpClientFactory INSTANCE = new DefaultHttpClientFactory();
    private static final Logger LOG = LoggerFactory.getLogger(DefaultHttpClientFactory.class);
    private static final byte[] LOCK = new byte[0];
    private static HttpClient sClient;
    static {
        sClient = new HttpClient(new ConnectionPool(Runtime.getRuntime().availableProcessors(), 45, TimeUnit.SECONDS));
        sClient.setConnectTimeout(10);
        sClient.setReadTimeout(20);
    }

    public static DefaultHttpClientFactory getInstance() {
        return INSTANCE;
    }

    public static void set(HttpClient client) {
        synchronized (LOCK) {
            HttpClient oldClient = sClient;
            sClient = client;
            try {
                oldClient.destroy();
            } catch (Exception e) {
                LOG.error("Failed to destroy http client", e);
            }

        }
        sClient = client;
    }

    private DefaultHttpClientFactory() {
    }

    @Override
    public HttpClient getHttpClient() {
        return sClient;
    }
}
