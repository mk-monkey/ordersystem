package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Class Name: OrderDetailDao
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-31 22:31
 **/

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
