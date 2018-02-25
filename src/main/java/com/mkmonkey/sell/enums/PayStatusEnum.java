package com.mkmonkey.sell.enums;

import lombok.Getter;

/**
 * @Class Name: PayStatusEnum
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-31 22:13
 **/
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
