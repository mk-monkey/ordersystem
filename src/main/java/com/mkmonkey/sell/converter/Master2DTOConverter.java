package com.mkmonkey.sell.converter;

import com.mkmonkey.sell.Bo.OrderMaster;
import com.mkmonkey.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Class Name: Master2DTOConverter
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 17:35
 **/

public class Master2DTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        return orderMasters.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
