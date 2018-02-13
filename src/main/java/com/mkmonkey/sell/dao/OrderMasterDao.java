package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Class Name: OrderMasterDao
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-31 22:28
 **/
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
