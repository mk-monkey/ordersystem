package com.mkmonkey.sell.Bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Class Name: ProductInfo
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-25 21:42
 **/
@Entity
@Data
public class ProductInfo {
    @Id
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
    //状态 0整除 1下架
    private Integer productStatus;
    //类目编号
    private Integer categoryType;
}
