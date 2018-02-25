package com.mkmonkey.sell.service;

import com.mkmonkey.sell.Bo.OrderMaster;
import com.mkmonkey.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Class Name: OrderService
 * @Description: 订单处理方法接口类
 * @Company bgy:  MK monkey
 * @create: 2018-02-13 12:55
 **/
public interface OrderService {

    /**
     * @Title: cteate //方法名
     * @Description: 创建订单
     * @Param: [orderDTO]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/13 下午1:06
     */
    OrderDTO cteate(OrderDTO orderDTO);

    /**
     * @Title: findOne //方法名
     * @Description: 根据 id 查询订单
     * @Param: [id]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/13 下午1:06
     */
    OrderDTO findOne(String id);

    /**
     * @Title: findList //方法名
     * @Description: 根据用户查询订单列表
     * @Param: [buyerOpenid, pageable]  //参数
     * @return: org.springframework.data.domain.Page<com.mkmonkey.sell.dto.OrderDTO> //返回值
     * @Author: MK monkey
     * @Date: 2018/2/13 下午1:08
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * @Title: cancel //方法名
     * @Description: 取消订单
     * @Param: [orderDTO]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/13 下午1:10
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * @Title: finish //方法名
     * @Description: 完成订单
     * @Param: [orderDTO]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/13 下午1:10
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * @Title: paid //方法名
     * @Description: 支付订单
     * @Param: [orderDTO]  //参数
     * @return: com.mkmonkey.sell.dto.OrderDTO //返回值
     * @Author: MK monkey
     * @Date: 2018/2/13 下午1:10
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * @Title: findList //方法名
     * @Description: 管理端查询订单列表方法
     * @Param: [pageable]  //参数
     * @return: org.springframework.data.domain.Page<com.mkmonkey.sell.dto.OrderDTO> //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午1:12
     */
    Page<OrderDTO> findList(Pageable pageable);


}