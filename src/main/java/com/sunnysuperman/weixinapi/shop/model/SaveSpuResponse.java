package com.sunnysuperman.weixinapi.shop.model;

import java.util.List;

public class SaveSpuResponse {

    public static class SaveSpuResponseSku {
        private String sku_id;
        private String out_sku_id;

        public String getSku_id() {
            return sku_id;
        }

        public void setSku_id(String sku_id) {
            this.sku_id = sku_id;
        }

        public String getOut_sku_id() {
            return out_sku_id;
        }

        public void setOut_sku_id(String out_sku_id) {
            this.out_sku_id = out_sku_id;
        }

    }

    public static class SaveSpuResponseData {
        private String product_id;
        private String out_product_id;
        private String create_time;
        private String update_time;
        private List<SaveSpuResponseSku> skus;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getOut_product_id() {
            return out_product_id;
        }

        public void setOut_product_id(String out_product_id) {
            this.out_product_id = out_product_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public List<SaveSpuResponseSku> getSkus() {
            return skus;
        }

        public void setSkus(List<SaveSpuResponseSku> skus) {
            this.skus = skus;
        }

    }

    private SaveSpuResponseData data;

    public SaveSpuResponseData getData() {
        return data;
    }

    public void setData(SaveSpuResponseData data) {
        this.data = data;
    }

}
