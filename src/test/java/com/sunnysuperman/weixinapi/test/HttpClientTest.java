package com.sunnysuperman.weixinapi.test;

import java.util.concurrent.TimeUnit;

import com.sunnysuperman.commons.task.CompleteAwareTaskEngine;
import com.sunnysuperman.http.client.HttpClient;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.message.SendMessageRequest;
import com.sunnysuperman.weixinapi.message.WeixinMessageApi;

import okhttp3.ConnectionPool;

public class HttpClientTest extends BaseTest {

    public void test() throws Exception {
        HttpClientFactory factory = new HttpClientFactory() {
            HttpClient client = new HttpClient(new ConnectionPool(2, 50, TimeUnit.SECONDS));

            @Override
            public HttpClient getHttpClient() {
                return client;
            }

        };
        HttpClientFactory factory2 = new HttpClientFactory() {
            HttpClient client = new HttpClient(new ConnectionPool(5, 50, TimeUnit.SECONDS));

            @Override
            public HttpClient getHttpClient() {
                return client;
            }

        };

        WeixinApp app = new WeixinApp(getString("mp.appid"), getString("mp.secret"), WeixinAppType.mp);

        WeixinMessageApi api = new WeixinMessageApi(app, factory, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mp.access-token");
            }

        });
        WeixinMessageApi api2 = new WeixinMessageApi(app, factory2, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mp.access-token");
            }

        });

        CompleteAwareTaskEngine engine = new CompleteAwareTaskEngine("weixin", 3);
        for (int i = 0; i < 100; i++) {
            engine.addTask(new Runnable() {

                @Override
                public void run() {
                    SendMessageRequest request = new SendMessageRequest();
                    try {
                        api.sendMessage(request);
                    } catch (WeixinApiException e) {
                        // System.err.println(e.getErrorMsg());
                    }
                    try {
                        Thread.sleep(1L * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
        for (int i = 0; i < 100; i++) {
            engine.addTask(new Runnable() {

                @Override
                public void run() {
                    SendMessageRequest request = new SendMessageRequest();
                    try {
                        api2.sendMessage(request);
                    } catch (WeixinApiException e) {
                        // System.err.println(e.getErrorMsg());
                    }
                }

            });
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    int count = factory.getHttpClient().getConnectionPool().idleConnectionCount();
                    System.out.println("Idle connection count1: " + count);

                    int count2 = factory2.getHttpClient().getConnectionPool().idleConnectionCount();
                    System.out.println("Idle connection count2: " + count2);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        engine.waitUntilTasksDone();
    }

}
