package com.mkmonkey.sell.enums;

import lombok.Getter;

/**
 * @Class Name: ProductStatusEnum
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 18:00
 **/
@Getter
public enum ProductStatusEnum {
    UP(0, "上架中"),
    DOWN(1, "下架中");
    private Integer code;
    private String Message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        Message = message;
    }
}
