package com.mkmonkey.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.mkmonkey.sell.dto.OrderDTO;

/**
 * @Class Name: PayService
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-23 02:41
 **/

public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    OrderDTO notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
