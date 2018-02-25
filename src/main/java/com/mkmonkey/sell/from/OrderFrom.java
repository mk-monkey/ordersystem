package com.mkmonkey.sell.from;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Class Name: OrderFrom
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 19:43
 **/
@Data
public class OrderFrom {

    /*
    卖家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    //买家地址
    @NotEmpty(message = "手机号必填")
    private String phone;
    //买家地址
    @NotEmpty(message = "地址必填")
    private String address;
    //用户微信 openID
    @NotEmpty(message = " openId 必填")
    private String openid;
    //购物车
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
