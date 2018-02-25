package com.mkmonkey.sell.excrption;

import com.mkmonkey.sell.enums.ResultEnum;

/**
 * @Class Name: SellException
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-13 13:28
 **/
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
        
    }
}
