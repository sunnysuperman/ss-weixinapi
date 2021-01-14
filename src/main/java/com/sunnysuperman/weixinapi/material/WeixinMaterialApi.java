package com.sunnysuperman.weixinapi.material;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.http.client.HttpUploadFile;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;

public class WeixinMaterialApi extends TokenAwareWeixinApi {

    public WeixinMaterialApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        super(app, tokenGetter);
    }

    public WeixinMaterialApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
    }

    public MaterialPage batchGet(String type, int offset, int count) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        params.put("offset", offset);
        params.put("count", count);
        return postJSON("cgi-bin/material/batchget_material?access_token=" + accessToken, params, new MaterialPage());
    }

    public Material addMaterial(String type, File file, String fileName) throws WeixinApiException {
        String accessToken = ensureAccessToken();

        HttpUploadFile uploadFile = new HttpUploadFile();
        uploadFile.setFile(file);
        uploadFile.setFileName(fileName);
        Map<String, Object> params = new HashMap<>();
        params.put("media", uploadFile);
        return postMultipart("cgi-bin/material/add_material?type=" + type + "&access_token=" + accessToken, params,
                new Material(), false);
    }

}
