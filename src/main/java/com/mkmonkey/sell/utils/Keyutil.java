package com.mkmonkey.sell.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Class Name: Keyutil
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-13 13:42
 **/
public class Keyutil {
    public static String genUniqueKey() {
        Date startTimes = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String startTime = sdf.format(startTimes);
        String str = "0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(10);
            buf.append(str.charAt(num));
        }
        int a = Integer.valueOf(buf.toString());
        return startTime + a;
    }

    public static String genProductKey() {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(10);
            buf.append(str.charAt(num));
        }
        Integer a = Integer.valueOf(buf.toString());
        return a.toString();
    }
}
