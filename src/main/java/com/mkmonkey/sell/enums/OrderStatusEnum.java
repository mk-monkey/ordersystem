package com.mkmonkey.sell.enums;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Getter;

/**
 * @Class Name: OrderStatusEnum
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-31 22:06
 **/
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),;
    private Integer code;
    private String Message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.Message = message;
    }

}
