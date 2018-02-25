package com.mkmonkey.sell.dto;

import lombok.Data;

/**
 * @Class Name: cartDTO
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 15:30
 **/
@Data
public class CartDTO {
    /*
       商品 id
     */
    private String productId;

    /*
    商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
