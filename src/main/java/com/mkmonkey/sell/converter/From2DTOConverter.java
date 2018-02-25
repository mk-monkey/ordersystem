package com.mkmonkey.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mkmonkey.sell.Bo.OrderDetail;
import com.mkmonkey.sell.dto.OrderDTO;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.from.OrderFrom;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name: From2DTOConverter
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 19:57
 **/
@Slf4j
public class From2DTOConverter {
    public static OrderDTO convert(OrderFrom orderFrom) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerPhone(orderFrom.getPhone());
        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerAddress(orderFrom.getAddress());
        orderDTO.setBuyerOpenid(orderFrom.getOpenid());
        List<OrderDetail> orderMasterList = new ArrayList<>();
        try {
            orderMasterList = gson.fromJson(orderFrom.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("[转换对象出错] error: json={}", orderFrom.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderMasterList);
        return orderDTO;
    }
}
