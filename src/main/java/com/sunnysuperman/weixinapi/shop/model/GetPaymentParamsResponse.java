package com.sunnysuperman.weixinapi.shop.model;

public class GetPaymentParamsResponse {

    private PaymentParamsResponse payment_params;

    public static class PaymentParamsResponse {
        private String timeStamp;
        private String nonceStr;
        private String pkg;
        private String paySign;
        private String signType;

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getPackage() {
            return pkg;
        }

        public void setPackage(String pkg) {
            this.pkg = pkg;
        }

        public String getPaySign() {
            return paySign;
        }

        public void setPaySign(String paySign) {
            this.paySign = paySign;
        }

        public String getSignType() {
            return signType;
        }

        public void setSignType(String signType) {

            this.signType = signType;
        }
    }

    public PaymentParamsResponse getPayment_params() {
        return payment_params;
    }

    public void setPayment_params(PaymentParamsResponse payment_params) {
        this.payment_params = payment_params;
    }
}
