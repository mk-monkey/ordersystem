package com.mkmonkey.sell.controller;

import com.mkmonkey.sell.Vo.ResultVo;
import com.mkmonkey.sell.converter.From2DTOConverter;
import com.mkmonkey.sell.dto.OrderDTO;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.from.OrderFrom;
import com.mkmonkey.sell.service.BuyerService;
import com.mkmonkey.sell.service.OrderService;
import com.mkmonkey.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class Name: BuyerOrderController
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-21 19:40
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderFrom orderFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("参数不正确, orderFrom={}", orderFrom);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage
                    ());
        }
        OrderDTO orderDTO = From2DTOConverter.convert(orderFrom);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.cteate(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        ResultVo resultVo = ResultVOUtil.success(map);
        return resultVo;
    }

    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid, @RequestParam(value = "page",
            defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("查询列表的 openid 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        log.info("orderDTOPage={}", orderDTOPage);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }


    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId) {
        //TODO 不安全的做法等待更新
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    @GetMapping("/cancel")
    public ResultVo<OrderDTO> cancel(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId) {
        //TODO 不安全的做法等待更新
        buyerService.cancelOrder(openid, orderId);

        return ResultVOUtil.success();
    }

}
