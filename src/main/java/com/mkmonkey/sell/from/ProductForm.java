package com.mkmonkey.sell.from;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Class Name: ProductForm
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 07:13
 **/
@Data
public class ProductForm {
    private String productId;
    //名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //类目编号
    private Integer categoryType;
}
