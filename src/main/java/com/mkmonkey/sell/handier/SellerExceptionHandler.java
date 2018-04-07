package com.mkmonkey.sell.handier;

import com.mkmonkey.sell.Vo.ResultVo;
import com.mkmonkey.sell.config.ProjectUrlConfig;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.excrption.SellerAuthorizeException;
import com.mkmonkey.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Class Name: ExceptionHandler
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-25 02:37
 **/
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig urlConfig;


    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthrizeException() {
        return new ModelAndView("redirecr:".concat(urlConfig.getWechatOpenAuthorize()).concat
                ("/sell/wechat/qrAuthorize").concat("?returnUrl=").concat(urlConfig.getSell()).concat
                ("/sell/seller/login"));
    }


    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVo handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

}
