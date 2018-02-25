package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.dto.OrderDTO;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.service.BuyerService;
import com.mkmonkey.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class Name: BuyerServiceImpl
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 22:15
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;


    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);

    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("[取消订单] 查不到此订单");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("[查询订单] 订单的 openid 不一致, openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
