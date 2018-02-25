package com.mkmonkey.sell.utils;

import com.mkmonkey.sell.enums.CodeEnum;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.CollationKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name: CookieUtil
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 11:05
 **/
public class CookieUtil {
    public static void set(HttpServletResponse response, String name, String value, Integer maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request, String name) {

        Map<String, Cookie> cookoeMap = readCookieMap(request);
        if (cookoeMap.containsKey(name)) {
            return cookoeMap.get(name);
        }
        return null;

    }

    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> cookoeMap = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookoeMap.put(cookie.getName(), cookie);

            }
        }
        return cookoeMap;
    }


}
