package com.mkmonkey.sell.service;

import com.mkmonkey.sell.dto.OrderDTO;

/**
 * @Class Name: BuyerService
 * @Description: 买家订单
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 22:12
 **/

public interface BuyerService {

    /**
     * @Title: findOrderOne //方法名
     * @Description: 查询一个订单
     * @Param: [openid, orderId]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/21 下午10:14
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * @Title: cencelOrder //方法名
     * @Description: 取消一个订单
     * @Param: [openid, orderId]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/21 下午10:14
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
