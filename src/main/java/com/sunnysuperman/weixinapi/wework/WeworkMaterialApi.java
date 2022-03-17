package com.sunnysuperman.weixinapi.wework;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.http.client.HttpUploadFile;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.material.Material;

public class WeworkMaterialApi extends WeworkCorpApi {

    public WeworkMaterialApi(WeixinApp app, WeixinAppTokenGetter tokenGetter, WeworkSuitApi workApi) {
        super(app, tokenGetter, workApi);
    }

    public WeworkMaterialApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter,
            WeworkSuitApi workApi) {
        super(app, httpClientFactory, tokenGetter, workApi);
    }

    public Material addMaterial(File file, String fileName) throws WeixinApiException {
        String accessToken = ensureAccessToken();
        HttpUploadFile uploadFile = new HttpUploadFile();
        uploadFile.setFile(file);
        uploadFile.setFileName(fileName);
        Map<String, Object> params = new HashMap<>();
        params.put("media", uploadFile);
        return postMultipart("/cgi-bin/media/uploadimg?access_token=" + accessToken, params, new Material(), false);
    }

}
