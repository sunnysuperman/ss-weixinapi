package com.sunnysuperman.weixinapi.merchant;

public interface WeixinMerchantApiFactory {

    WeixinMerchantApi createByAppId(String appId);

}
