package com.mkmonkey.sell.controller;

import com.mkmonkey.sell.dto.OrderDTO;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Class Name: SellerOrderController
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 01:21
 **/
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Title: list //方法名
     * @Description: TODO
     * @Param: [page, size] page 第几页; size 一页的数据
     * @return: org.springframework.web.servlet.ModelAndView //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午1:24
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(
            value = "size", defaultValue = "10") Integer size, Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currebtPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * @Title: cancel //方法名
     * @Description: 取消订单操作
     * @Param: [orderId]  //参数
     * @return: org.springframework.web.servlet.ModelAndView //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午4:08
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        map.put("url", "/sell/seller/order/list");
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (Exception e) {
            log.error("[买家端-取消订单出错] 查询不到此订单");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        return new ModelAndView("success", map);
    }

    /**
     * @Title: detail //方法名
     * @Description: 查询订单详情
     * @Param: [orderId, map]  //参数
     * @return: org.springframework.web.servlet.ModelAndView //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午4:52
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        try {
            map.put("orderDTO", orderService.findOne(orderId));
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/success", map);
        } catch (Exception e) {
            log.error("[买家端-订单详情] 查询不到此订单");
            map.put("url", "/sell/seller/order/list");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * @Title: finish //方法名
     * @Description: TODO
     * @Param: [orderId, map]  //参数
     * @return: org.springframework.web.servlet.ModelAndView //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午5:09
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        map.put("url", "/sell/seller/order/list");
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (Exception e) {
            log.error("[买家端-取消订单出错] 查询不到此订单");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        return new ModelAndView("success", map);
    }
}
