package com.mkmonkey.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.bcel.internal.generic.GOTO;

/**
 * @Class Name: JsonUtil
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-23 10:47
 **/
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
