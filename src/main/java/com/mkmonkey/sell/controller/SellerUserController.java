package com.mkmonkey.sell.controller;

import com.mkmonkey.sell.Bo.SellerInfo;
import com.mkmonkey.sell.config.ProjectUrlConfig;
import com.mkmonkey.sell.constant.CookieConstant;
import com.mkmonkey.sell.constant.RedisConstant;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.service.SellerService;
import com.mkmonkey.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Class Name: SellerUserController
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 10:37
 **/
@Controller
@Slf4j
@RequestMapping("/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid, Map<String, Object> map, HttpServletResponse
            response) {
        SellerInfo sellerInfo = sellerService.findSellerOPenid(openid);
        if (sellerInfo == null) {
            log.error("[查询管理员]  管理员openid不存在  openid={}", openid);
            throw new SellException(ResultEnum.LOGIN_FAIL);
        }
        //设置 token
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit
                .SECONDS);
        //设置 token 到 cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request, Map<String, Object> map) {
        //从 cookie 查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //清除 cooki
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie
                    .getValue()));
            //删除 cookie

            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT);
        map.put("url", projectUrlConfig.getSell() + "sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
