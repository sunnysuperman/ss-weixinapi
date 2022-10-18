package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class CreateOrderRequest {

    private String create_time;
    private String out_order_id;
    private String openid;
    private String path;
    private int scene = 1000;
    private OrderDetail order_detail;
    private DeliveryDetail delivery_detail = new DeliveryDetail();
    private AddressInfo address_info;
    private int fund_type = 1;
    private long expire_time;

    public static class DeliveryDetail {

        private int delivery_type = 1;

        public int getDelivery_type() {
            return delivery_type;
        }

        public void setDelivery_type(int delivery_type) {
            this.delivery_type = delivery_type;
        }

    }

    public static class OrderDetail {
        private List<ProductInfo> product_infos;
        private PayInfo pay_info = new PayInfo() {
            {
                setPay_method_type(0);
            }
        };
        private PriceInfo price_info;

        public List<ProductInfo> getProduct_infos() {
            return product_infos;
        }

        public void setProduct_infos(List<ProductInfo> product_infos) {
            this.product_infos = product_infos;
        }

        public PayInfo getPay_info() {
            return pay_info;
        }

        public void setPay_info(PayInfo pay_info) {
            this.pay_info = pay_info;
        }

        public PriceInfo getPrice_info() {
            return price_info;
        }

        public void setPrice_info(PriceInfo price_info) {
            this.price_info = price_info;
        }
    }

    public void validate() {
        long sumSkuRealPrice = 0;
        long salePrice = 0;
        for (ProductInfo item : this.order_detail.getProduct_infos()) {
            sumSkuRealPrice += item.getSku_real_price();
            salePrice += item.getSale_price() * item.getProduct_cnt();
        }
        Long freight = this.order_detail.getPrice_info().getFreight();

        Long order_price = this.order_detail.getPrice_info().getOrder_price();
        if (order_price != sumSkuRealPrice + freight) {
            throw new RuntimeException("code 1");
        }
        Long discounted_price = order_detail.getPrice_info().getDiscounted_price();
        if (discounted_price == null) {
            discounted_price = 0L;
        }
        if (order_price != salePrice - discounted_price) {
            throw new RuntimeException("code 2");
        }
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getOut_order_id() {
        return out_order_id;
    }

    public void setOut_order_id(String out_order_id) {
        this.out_order_id = out_order_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public OrderDetail getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(OrderDetail order_detail) {
        this.order_detail = order_detail;
    }

    public DeliveryDetail getDelivery_detail() {
        return delivery_detail;
    }

    public void setDelivery_detail(DeliveryDetail delivery_detail) {
        this.delivery_detail = delivery_detail;
    }

    public AddressInfo getAddress_info() {
        return address_info;
    }

    public void setAddress_info(AddressInfo address_info) {
        this.address_info = address_info;
    }

    public int getFund_type() {
        return fund_type;
    }

    public void setFund_type(int fund_type) {
        this.fund_type = fund_type;
    }

    public long getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(long expire_time) {
        this.expire_time = expire_time;
    }
}
