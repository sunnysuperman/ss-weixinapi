package com.sunnysuperman.weixinapi.message;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinMessageApi extends TokenAwareWeixinApi {

    public WeixinMessageApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public WeixinMessageApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
    }

    public SendMessageResponse sendMessage(SendMessageRequest request) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        Map<String, Object> params = new HashMap<>();
        params.put("touser", request.getTouser());
        params.put("template_id", request.getTemplate_id());
        params.put("url", request.getUrl());
        params.put("data", request.getData());
        params.put("miniprogram", request.getMiniprogram());
        return postJSON("cgi-bin/message/template/send?access_token=" + accessToken, params, new SendMessageResponse());
    }

    public AddTemplateResponse addTemplate(String templateIdShort) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        Map<String, Object> params = new HashMap<>();
        params.put("template_id_short", templateIdShort);
        return postJSON("cgi-bin/template/api_add_template?access_token=" + accessToken, params,
                new AddTemplateResponse());
    }

    public void removeTemplate(String templateId) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        Map<String, Object> params = new HashMap<>();
        params.put("template_id", templateId);
        postJSON("cgi-bin/template/del_private_template?access_token=" + accessToken, params, new BaseResponse());
    }

    public GetTemplatesResponse getTemplates() throws WeixinApiException {
        String accessToken = ensureAccessToken();

        return get("cgi-bin/template/get_all_private_template?access_token=" + accessToken, null,
                new GetTemplatesResponse());
    }

    public SendMessageResponse sendCustomMessage(SendCustomMessageRequest request) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        Map<String, Object> params = new HashMap<>();
        params.put("touser", request.getTouser());
        if (request.getText() != null) {
            params.put("msgtype", "text");
            params.put("text", Collections.singletonMap("content", request.getText()));
        } else if (request.getImage() != null) {
            params.put("msgtype", "image");
            params.put("image", Collections.singletonMap("media_id", request.getImage()));
        } else if (request.getVoice() != null) {
            params.put("msgtype", "voice");
            params.put("voice", Collections.singletonMap("media_id", request.getVoice()));
        } else if (request.getVideo() != null) {
            params.put("msgtype", "video");
            Map<String, Object> videoContent = new HashMap<>();
            videoContent.put("media_id", request.getVideo().getMediaId());
            videoContent.put("thumb_media_id", request.getVideo().getThumbMediaId());
            videoContent.put("title", request.getVideo().getTitle());
            videoContent.put("description", request.getVideo().getDescription());
            params.put("video", videoContent);
        } else if (request.getArticles() != null) {
            params.put("msgtype", "news");
            params.put("news", Collections.singletonMap("articles", request.getArticles()));
        } else if (request.getMpNewsId() != null) {
            params.put("msgtype", "mpnews");
            params.put("mpnews", Collections.singletonMap("media_id", request.getMpNewsId()));
        } else {
            throw new IllegalArgumentException("Bad message type");
        }
        return postJSON("cgi-bin/message/custom/send?access_token=" + accessToken, params, new SendMessageResponse());
    }

}
