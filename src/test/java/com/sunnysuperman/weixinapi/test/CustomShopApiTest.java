package com.sunnysuperman.weixinapi.test;

import java.util.Arrays;

import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.WeixinApp;
import com.sunnysuperman.weixinapi.WeixinAppTokenGetter;
import com.sunnysuperman.weixinapi.WeixinAppType;
import com.sunnysuperman.weixinapi.exception.WeixinBadAccessTokenException;
import com.sunnysuperman.weixinapi.shop.CustomShopApi;
import com.sunnysuperman.weixinapi.shop.model.AddSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.AddSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.GetAllCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetShopCategoryListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuListResponse;
import com.sunnysuperman.weixinapi.shop.model.GetSpuRequest;
import com.sunnysuperman.weixinapi.shop.model.GetSpuResponse;
import com.sunnysuperman.weixinapi.shop.model.Sku;
import com.sunnysuperman.weixinapi.shop.model.SkuAttr;
import com.sunnysuperman.weixinapi.shop.model.Spu;

public class CustomShopApiTest extends BaseTest {
    private CustomShopApi api;

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
        AddSpuResponse response = api.addSpu(req);

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
}
