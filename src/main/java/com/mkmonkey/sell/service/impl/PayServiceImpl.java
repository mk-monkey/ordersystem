package com.mkmonkey.sell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.mkmonkey.sell.dto.OrderDTO;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.service.OrderService;
import com.mkmonkey.sell.service.PayService;
import com.mkmonkey.sell.utils.JsonUtil;
import com.mkmonkey.sell.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Class Name: PayServiceImpl
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-23 02:42
 **/
@Service
@Slf4j
public class PayServiceImpl implements PayService {
    private static final String ORDRT_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDRT_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[发起支付] payRequest={},orderid={}", payRequest, orderDTO);
        PayResponse pay = bestPayService.pay(payRequest);
        log.info("[发起支付] pay={}", JsonUtil.toJson(pay));
        return pay;
    }

    @Override
    public OrderDTO notify(String notifyData) {
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("[微信支付通知] 异步通知, payResponse={}", JsonUtil.toJson(payResponse));

        //获取获取订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        if (orderDTO == null) {
            log.error("[微信支付通知] 异步通知, 订单不存在, orderDTO={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断金额是否一致
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.info("[微信支付通知] 异步通知, 订单金额不一致, orderDTO={},微信通知金额={},系统金额={}", payResponse.getOrderId(), payResponse
                    .getOrderAmount(), orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //修改支付状态
        OrderDTO orderOver = orderService.paid(orderDTO);
        return orderOver;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信退款] refundRequest={}", JsonUtil.toJson(refundRequest));
        RefundResponse refund = bestPayService.refund(refundRequest);
        log.info("[微信退款] refund={}", JsonUtil.toJson(refund));

        return refund;
    }
}
