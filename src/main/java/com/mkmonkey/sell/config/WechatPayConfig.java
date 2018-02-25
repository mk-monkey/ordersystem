package com.mkmonkey.sell.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Class Name: WechatPayConfig
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-23 03:06
 **/
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public BestPayServiceImpl bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(payH5Config());
        return bestPayService;
    }

    @Bean
    public WxPayH5Config payH5Config() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(accountConfig.getMyAppId());
        wxPayH5Config.setAppSecret(accountConfig.getMyAppSecret());
        wxPayH5Config.setMchId(accountConfig.getMyMchId());
        wxPayH5Config.setKeyPath(accountConfig.getMyKeyPath());
        wxPayH5Config.setMchKey(accountConfig.getMyMchKey());
        wxPayH5Config.setNotifyUrl(accountConfig.getMyNotifyUrl());
        return wxPayH5Config;
    }
}
