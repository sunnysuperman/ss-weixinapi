package com.sunnysuperman.weixinapi.test;

import java.util.Arrays;
import java.util.List;

import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.shop.CustomShopApi;
import com.sunnysuperman.weixinapi.shop.model.AddSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.DelistingRequest;
import com.sunnysuperman.weixinapi.shop.model.DeliverRequest;
import com.sunnysuperman.weixinapi.shop.model.GetAllCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetOrderRequest;
import com.sunnysuperman.weixinapi.shop.model.GetOrderResponse;
import com.sunnysuperman.weixinapi.shop.model.GetShopCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.PayOrderRequest;
import com.sunnysuperman.weixinapi.shop.model.ReceiveRequest;
import com.sunnysuperman.weixinapi.shop.model.SaveSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.Sku;
import com.sunnysuperman.weixinapi.shop.model.SkuAttr;
import com.sunnysuperman.weixinapi.shop.model.Spu;

public class CustomShopApiTest extends BaseTest {
    private CustomShopApi api;
    private String outOrderId = "xx";
    private String openid = "xx";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WeixinApp app = new WeixinApp(getString("mini.appid"), getString("mini.secret"), WeixinAppType.mini);
        api = new CustomShopApi(app, new WeixinAppTokenGetter() {

            @Override
            public String getAccessToken() throws WeixinBadAccessTokenException {
                return getString("mini.access-token");
            }

        });
    }

    public void test_getAllCategoryList() throws Exception {
        GetAllCategoryListResponse response = api.getAllCategoryList();

        System.out.println(JSONUtil.toJSONString(response));
        assertTrue(!response.getThird_cat_list().isEmpty());
    }

    public void test_getShopCategoryList() throws Exception {
        GetShopCategoryListResponse response = api.getShopCategoryList();

        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_addSpu() throws Exception {
        AddSpuRequest req = new AddSpuRequest();
        req.setOut_product_id("p123457");
        req.setTitle("XX");
        req.setPath("pages/wxshop/product?id=" + req.getOut_product_id());
        req.setHead_img(Arrays.asList("http://xx.png"));
        req.setThird_cat_id(422003);
        Sku sku1 = new Sku();
        sku1.setOut_product_id(req.getOut_product_id());
        sku1.setOut_sku_id("s123456");
        sku1.setThumb_img("http://xx.png");
        sku1.setSale_price(1);
        sku1.setMarket_price(100);
        sku1.setStock_num(1000);
        sku1.setSku_attrs(Arrays.asList(new SkuAttr("规格", "默认")));
        req.setSkus(Arrays.asList(sku1));
        SaveSpuResponse response = api.addSpu(req);

        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_getSpu() throws Exception {
        GetSpuListRequest request = new GetSpuListRequest();
        GetSpuListResponse response = api.getSpuList(request);

        System.out.println(JSONUtil.toJSONString(response));
        if (!response.getSpus().isEmpty()) {
            Spu spu = response.getSpus().get(0);
            getSpu(spu.getOut_product_id(), (byte) 0);
            getSpu(spu.getOut_product_id(), (byte) 1);
        }
    }

    private void getSpu(String outProductId, byte needEditSpu) throws Exception {
        GetSpuRequest request = new GetSpuRequest();
        request.setOut_product_id(outProductId);
        request.setNeed_edit_spu(needEditSpu);
        GetSpuResponse response = api.getSpu(request);
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_getListing() throws Exception {
        GetSpuListRequest getSpuListRequest = new GetSpuListRequest();
        getSpuListRequest.setStatus(5);
        GetSpuListResponse getSpuListResponse = api.getSpuList(getSpuListRequest);
        System.out.println(JSONUtil.toJSONString(getSpuListResponse));
    }

    public void test_getDelisting() throws Exception {
        GetSpuListRequest getSpuListRequest = new GetSpuListRequest();
        getSpuListRequest.setStatus(0);
        GetSpuListResponse getSpuListResponse = api.getSpuList(getSpuListRequest);
        System.out.println(JSONUtil.toJSONString(getSpuListResponse));
    }

    public void test_listing() throws Exception {
        while (true) {
            GetSpuListRequest getSpuListRequest = new GetSpuListRequest();
            getSpuListRequest.setStatus(5);
            GetSpuListResponse getSpuListResponse = api.getSpuList(getSpuListRequest);
            List<Spu> spuList = getSpuListResponse.getSpus();
            if (spuList.isEmpty()) {
                break;
            }
            for (Spu spu : spuList) {
                DelistingRequest request = new DelistingRequest();
                request.setProduct_id(spu.getProduct_id());
                api.delistingSpu(request);
            }
        }
    }

    public void test_payOrder() throws Exception {
        PayOrderRequest request = new PayOrderRequest();
        request.setOut_order_id(outOrderId);
        request.setOpenid(openid);
        request.setAction_type(1);
        request.setTransaction_id("123");
        request.setPay_time("2021-05-06 22:00:00");
        api.payOrder(request);
    }

    public void test_getOrder() throws Exception {
        GetOrderRequest request = new GetOrderRequest();
        request.setOut_order_id(outOrderId);
        request.setOpenid(openid);
        GetOrderResponse response = api.getOrder(request);
        assertTrue(response.getOrder().getOrder_id() != null);
        System.out.println(JSONUtil.toJSONString(response));
    }

    public void test_deliver() throws Exception {
        DeliverRequest request = new DeliverRequest();
        request.setOut_order_id(outOrderId);
        request.setOpenid(openid);
        request.setFinish_all_delivery((byte) 1);
        api.deliver(request);
    }

    public void test_receive() throws Exception {
        ReceiveRequest request = new ReceiveRequest();
        request.setOut_order_id(outOrderId);
        request.setOpenid(openid);
        api.receive(request);
    }
}
