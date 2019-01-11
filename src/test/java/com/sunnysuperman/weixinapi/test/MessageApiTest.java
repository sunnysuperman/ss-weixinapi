package com.sunnysuperman.weixinapi.test;

import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.message.SendCustomMessageRequest;
import com.sunnysuperman.weixinapi.message.SendCustomMessageRequest.ArticleMessage;
import com.sunnysuperman.weixinapi.message.SendMessageResponse;
import com.sunnysuperman.weixinapi.message.WeixinMessageApi;

public class MessageApiTest extends BaseTest {
    private WeixinMessageApi api;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("mp.appid"), getString("mp.secret"), WeixinAppType.mp);
        api = new WeixinMessageApi(app, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mp.access-token");
            }

        });
    }

    public void test_sendCustomMessage() throws Exception {
        SendCustomMessageRequest request = new SendCustomMessageRequest();
        request.setTouser("xx");
        request.setText("这是测试😓客服消息😓");
        api.sendCustomMessage(request);
    }

    public void test_sendCustomMessageArticle() throws Exception {
        SendCustomMessageRequest request = new SendCustomMessageRequest();
        request.setTouser("oyNtA0q0JFPiX9mflFweW8nwIvJs");
        ArticleMessage article = new ArticleMessage();
        article.setTitle("推送标题");
        article.setDescription("推送简介");
        article.setUrl("http://www.baidu.com/");
        article.setPicurl("http://sandbox-c2.wakkaa.com/wks/100045/2019/1/5/v/5c30534ccfab57451ca82a58.jpeg");
        request.setArticles(new ArticleMessage[] { article });
        try {
            SendMessageResponse response = api.sendCustomMessage(request);
            assertTrue(response.getMsgid() != null);
        } catch (WeixinApiException ex) {
            System.err.println(ex.getErrorCode() + ":" + ex.getErrorMsg());
            assertTrue(false);
        }
    }
}
