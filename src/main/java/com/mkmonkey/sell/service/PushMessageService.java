package com.mkmonkey.sell.service;

import com.mkmonkey.sell.dto.OrderDTO;

/**
 * @Class Name: PushMessageService
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-04-07 12:22
 **/
public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);

}
