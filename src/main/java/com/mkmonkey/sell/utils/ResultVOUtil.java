package com.mkmonkey.sell.utils;

import com.mkmonkey.sell.Vo.ResultVo;

/**
 * @Class Name: ResultVOUtil
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 20:27
 **/
public class ResultVOUtil {
    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
