package com.mkmonkey.sell.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Class Name: ProductInofoVo
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 18:52
 **/
@Data
public class ProductInofoVo {
    //id
    @JsonProperty("id")
    private String productId;
    //名字
    @JsonProperty("name")
    private String productName;

    //单价
    @JsonProperty("price")
    private BigDecimal productPrice;

    //描述
    @JsonProperty("description")
    private String productDescription;

    //小图
    @JsonProperty("icon")
    private String productIcon;
}
