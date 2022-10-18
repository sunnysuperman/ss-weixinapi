package com.sunnysuperman.weixinapi.shop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.BaseResponse;
import com.sunnysuperman.weixinapi.HttpClientFactory;
import com.sunnysuperman.weixinapi.TokenAwareWeixinApi;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.exception.WeixinApiException;
import com.sunnysuperman.weixinapi.shop.model.AddAftersaleRequest;
import com.sunnysuperman.weixinapi.shop.model.AddSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.AfterSaleAddRequest;
import com.sunnysuperman.weixinapi.shop.model.AuditCategoryReq;
import com.sunnysuperman.weixinapi.shop.model.AuditCategoryRequest;
import com.sunnysuperman.weixinapi.shop.model.AuditCategoryResponse;
import com.sunnysuperman.weixinapi.shop.model.AuditResponse;
import com.sunnysuperman.weixinapi.shop.model.CreateOrderRequest;
import com.sunnysuperman.weixinapi.shop.model.CreateOrderResponse;
import com.sunnysuperman.weixinapi.shop.model.CustomerServiceAccount;
import com.sunnysuperman.weixinapi.shop.model.DeleteAuditRequest;
import com.sunnysuperman.weixinapi.shop.model.DeleteRequest;
import com.sunnysuperman.weixinapi.shop.model.DelistingRequest;
import com.sunnysuperman.weixinapi.shop.model.DeliverRequest;
import com.sunnysuperman.weixinapi.shop.model.GetAfterSalesOrderResponse;
import com.sunnysuperman.weixinapi.shop.model.GetAllCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetCompanyListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetCustomerServiceAccountResponse;
import com.sunnysuperman.weixinapi.shop.model.GetOrderRequest;
import com.sunnysuperman.weixinapi.shop.model.GetOrderResponse;
import com.sunnysuperman.weixinapi.shop.model.GetPaymentParamsRequest;
import com.sunnysuperman.weixinapi.shop.model.GetPaymentParamsResponse;
import com.sunnysuperman.weixinapi.shop.model.GetShopCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.ImgUploadResponse;
import com.sunnysuperman.weixinapi.shop.model.ListingRequest;
import com.sunnysuperman.weixinapi.shop.model.PayOrderRequest;
import com.sunnysuperman.weixinapi.shop.model.ReceiveRequest;
import com.sunnysuperman.weixinapi.shop.model.SaveSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.UpdateSpuRequest;

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

    public SaveSpuResponse addSpu(AddSpuRequest request) throws WeixinApiException {
        return postJSON("shop/spu/add?access_token=" + ensureAccessToken(), request, new SaveSpuResponse());
    }

    public SaveSpuResponse updateSpu(UpdateSpuRequest request) throws WeixinApiException {
        return postJSON("shop/spu/update?access_token=" + ensureAccessToken(), request, new SaveSpuResponse());
    }

    public GetSpuListResponse getSpuList(GetSpuListRequest request) throws WeixinApiException {
        return postJSON("shop/spu/get_list?access_token=" + ensureAccessToken(), request, new GetSpuListResponse());
    }

    public GetSpuResponse getSpu(GetSpuRequest request) throws WeixinApiException {
        return postJSON("shop/spu/get?access_token=" + ensureAccessToken(), request, new GetSpuResponse());
    }

    public void listingSpu(ListingRequest request) throws WeixinApiException {
        postJSON("shop/spu/listing?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public void delistingSpu(DelistingRequest request) throws WeixinApiException {
        postJSON("shop/spu/delisting?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public void deleteSpu(DeleteRequest request) throws WeixinApiException {
        postJSON("shop/spu/del?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public void deleteSpuAudit(DeleteAuditRequest request) throws WeixinApiException {
        postJSON("shop/spu/del_audit?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) throws WeixinApiException {
        return postJSON("shop/order/add?access_token=" + ensureAccessToken(), request, new CreateOrderResponse());
    }

    public GetOrderResponse getOrder(GetOrderRequest request) throws WeixinApiException {
        return postJSON("shop/order/get?access_token=" + ensureAccessToken(), request, new GetOrderResponse());
    }

    public void payOrder(PayOrderRequest request) throws WeixinApiException {
        postJSON("shop/order/pay?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public void deliver(DeliverRequest request) throws WeixinApiException {
        String api = "shop/delivery/send?access_token=" + ensureAccessToken();
        postJSON(api, request, new BaseResponse());
    }

    public void receive(ReceiveRequest request) throws WeixinApiException {
        postJSON("shop/delivery/recieve?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public void addAftersale(AddAftersaleRequest request) throws WeixinApiException {
        postJSON("shop/aftersale/add?access_token=" + ensureAccessToken(), request, new BaseResponse());
    }

    public AuditResponse auditCategory(AuditCategoryReq request) throws WeixinApiException {
        return postJSON("shop/audit/audit_category?access_token=" + ensureAccessToken(),
                new AuditCategoryRequest(request), new AuditResponse());
    }

    public AuditCategoryResponse auditCategoryResult(String auditId) throws WeixinApiException {
        return postJSON("shop/audit/result?access_token=" + ensureAccessToken(),
                Collections.singletonMap("audit_id", auditId), new AuditCategoryResponse());
    }

    public ImgUploadResponse imgUpload(String imgUrl) throws WeixinApiException {
        Map<String, Object> map = new HashMap<>();
        map.put("resp_type", 1);
        map.put("upload_type", 1);
        map.put("img_url", imgUrl);
        return post("shop/img/upload?access_token=" + ensureAccessToken(), map, new ImgUploadResponse());
    }

    public GetCustomerServiceAccountResponse getCustomerServiceAccount() throws WeixinApiException {
        return postJSON("shop/account/get_info?access_token=" + ensureAccessToken(), Collections.emptyMap(),
                new GetCustomerServiceAccountResponse());
    }

    public void updateCustomerServiceAccount(CustomerServiceAccount accountInfo) throws WeixinApiException {
        postJSON("shop/account/update_info?access_token=" + ensureAccessToken(), accountInfo, new BaseResponse());
    }

    public GetPaymentParamsResponse getPaymentParams(GetPaymentParamsRequest request) throws WeixinApiException {
        return postJSON("shop/order/getpaymentparams?access_token=" + ensureAccessToken(), request,
                new GetPaymentParamsResponse());
    }

    public GetCompanyListResponse getCompanyList() throws WeixinApiException {
        return postJSON("shop/delivery/get_company_list?access_token=" + ensureAccessToken(), Collections.emptyMap(),
                new GetCompanyListResponse());
    }

    public void updateAfterSale(AfterSaleAddRequest req) throws WeixinApiException {
        String api = "shop/ecaftersale/update?access_token=" + ensureAccessToken();
        postJSON(api, req, new BaseResponse());
    }

    public GetAfterSalesOrderResponse getAfterSale(String outAftersaleId) throws WeixinApiException {
        String api = "shop/ecaftersale/get?access_token=" + ensureAccessToken();
        return postJSON(api, Collections.singletonMap("out_aftersale_id", outAftersaleId),
                new GetAfterSalesOrderResponse());
    }

    public void addAfterSale(AfterSaleAddRequest req) throws WeixinApiException {
        postJSON("shop/ecaftersale/add?access_token=" + ensureAccessToken(), req, new BaseResponse());
    }

    public void acceptRefund(Long aftersaleId) throws WeixinApiException {
        postJSON("shop/ecaftersale/acceptrefund?access_token=" + ensureAccessToken(),
                Collections.singletonMap("aftersale_id", aftersaleId), new BaseResponse());
    }

    public void acceptRefund(String outAftersaleId) throws WeixinApiException {
        postJSON("shop/ecaftersale/acceptrefund?access_token=" + ensureAccessToken(),
                Collections.singletonMap("out_aftersale_id", outAftersaleId), new BaseResponse());
    }

    public SaveSpuResponse updateSpuWithoutAudit(UpdateSpuRequest req) throws WeixinApiException {
        String api = "shop/spu/update_without_audit?access_token=" + ensureAccessToken();
        return postJSON(api, req, new SaveSpuResponse());
    }
}
