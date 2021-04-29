package com.sunnysuperman.weixinapi.shop;

import java.util.Collections;

import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.shop.model.AddSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.AddSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.CreateOrderRequest;
import com.sunnysuperman.weixinapi.shop.model.CreateOrderResponse;
import com.sunnysuperman.weixinapi.shop.model.GetAllCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetShopCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.PayOrderRequest;

public class CustomShopApi extends TokenAwareWeixinApi {

    public CustomShopApi(WeixinApp app, HttpClientFactory httpClientFactory, WeixinAppTokenGetter tokenGetter) {
        super(app, httpClientFactory, tokenGetter);
    }

    public CustomShopApi(WeixinApp app, WeixinAppTokenGetter tokenGetter) {
        this(app, null, tokenGetter);
    }

    public CustomShopApi(WeixinApp app) {
        this(app, null, null);
    }

    public GetAllCategoryListResponse getAllCategoryList() throws WeixinApiException {
        return postJSON("shop/cat/get?access_token=" + ensureAccessToken(), Collections.emptyMap(),
                new GetAllCategoryListResponse());
    }

    public GetShopCategoryListResponse getShopCategoryList() throws WeixinApiException {
        return postJSON("shop/account/get_category_list?access_token=" + ensureAccessToken(), Collections.emptyMap(),
                new GetShopCategoryListResponse());
    }

    public AddSpuResponse addSpu(AddSpuRequest request) throws WeixinApiException {
        return postJSON("shop/spu/add?access_token=" + ensureAccessToken(), request, new AddSpuResponse());
    }

    public GetSpuListResponse getSpuList(GetSpuListRequest request) throws WeixinApiException {
        return postJSON("shop/spu/get_list?access_token=" + ensureAccessToken(), request, new GetSpuListResponse());
    }

    public GetSpuResponse getSpu(GetSpuRequest request) throws WeixinApiException {
        return postJSON("shop/spu/get?access_token=" + ensureAccessToken(), request, new GetSpuResponse());
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) throws WeixinApiException {
        return postJSON("shop/order/add?access_token=" + ensureAccessToken(), request, new CreateOrderResponse());
    }

    public void payOrder(PayOrderRequest request) throws WeixinApiException {
        postJSON("shop/order/pay?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }
}
