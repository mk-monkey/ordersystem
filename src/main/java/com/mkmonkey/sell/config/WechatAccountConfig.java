package com.mkmonkey.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Class Name: WechatAccountConfig
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-22 21:11
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    //微信公众平台
    private String myAppId;
    //微信公众平台密码
    private String myAppSecret;
    //    微信开放平台
    private String openAppId;
    //开放平台秘钥
    private String openAppSecret;

    //商户号
    private String myMchId;
    //商户秘钥
    private String myMchKey;
    //商户证书路径
    private String myKeyPath;
    //微信支付异步通知地址
    private String myNotifyUrl;
    /**
     * 微信模版id
     */
    private Map<String, String> templateId;

}
