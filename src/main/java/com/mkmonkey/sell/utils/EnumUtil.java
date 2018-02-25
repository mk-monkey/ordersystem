package com.mkmonkey.sell.utils;

import com.mkmonkey.sell.enums.CodeEnum;

/**
 * @Class Name: EnumUtil
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 03:11
 **/
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
