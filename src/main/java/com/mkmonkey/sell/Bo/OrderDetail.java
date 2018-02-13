package com.mkmonkey.sell.Bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Class Name: OrderDetail
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-31 22:18
 **/
@Data
@Entity
public class OrderDetail {
    //追歼 id
    @Id
    private String detailId;
    //订单 id
    private String orderId;
    //商品 id
    private String productId;
    //商品名称
    private String productName;
    //商品单价
    private BigDecimal productPrice;
    //商品数量
    private Integer productQuantity;
    //商品小图
    private String productIcon;
}
