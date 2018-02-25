package com.mkmonkey.sell.aspect;

import com.mkmonkey.sell.constant.CookieConstant;
import com.mkmonkey.sell.constant.RedisConstant;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.excrption.SellerAuthorizeException;
import com.mkmonkey.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Class Name: SellerAuthorizeAspcet
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-25 02:21
 **/
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspcet {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.mkmonkey.sell.controller.Seller*.*(..))" + "&&!execution(public * com.mkmonkey" +
            ".sell.controller.SellerUserController.login(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("登录效验] cookie 中查不到 token");
            throw new SellerAuthorizeException();
        }
        //去 redis 里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("[登录效验] redis 中查不到 token");
            throw new SellerAuthorizeException();
        }
    }
}
