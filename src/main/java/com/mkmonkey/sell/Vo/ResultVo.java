package com.mkmonkey.sell.Vo;

import lombok.Data;

/**
 * @Class Name: ResultVo
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 18:37
 **/
@Data
public class ResultVo<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;
}