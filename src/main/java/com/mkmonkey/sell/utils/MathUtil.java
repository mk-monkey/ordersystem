package com.mkmonkey.sell.utils;

/**
 * @Class Name: MathUtil
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-23 12:37
 **/
public class MathUtil {
    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2) {
        Double rusult = Math.abs(d1 - d2);
        if (rusult < MONEY_RANGE) {
            return true;
        }
        return false;
    }
}
