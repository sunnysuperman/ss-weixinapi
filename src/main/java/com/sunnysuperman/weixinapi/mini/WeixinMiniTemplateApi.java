package com.sunnysuperman.weixinapi.mini;

import java.util.Collections;
import java.util.List;

import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.WeixinApi;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinMiniTemplateApi extends WeixinApi {
    private String componentAccessToken;

    public WeixinMiniTemplateApi(String componentAccessToken) {
        super(null);
        this.componentAccessToken = componentAccessToken;
    }

    public List<MiniTemplate> getTemplateList() throws WeixinApiException {
        GetTemplateListResponse response = get("wxa/gettemplatelist?access_token=" + componentAccessToken, null,
                new GetTemplateListResponse());
        return response.getTemplate_list();
    }

    public void addToTemplate(Integer draftId) throws WeixinApiException {
        postJSON("wxa/addtotemplate?access_token=" + componentAccessToken,
                Collections.singletonMap("draft_id", draftId), new BaseResponse());
    }

    public void deleteTemplate(Integer templateId) throws WeixinApiException {
        postJSON("wxa/deletetemplate?access_token=" + componentAccessToken,
                Collections.singletonMap("template_id", templateId), new BaseResponse());
    }
}
