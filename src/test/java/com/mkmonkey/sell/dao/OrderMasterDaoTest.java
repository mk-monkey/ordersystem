package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String openid = "1234567";

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("monkey");
        orderMaster.setBuyerPhone("1888888888");
        orderMaster.setBuyerAddress("麻布新村");
        orderMaster.setBuyerOpenid("1234567");
        orderMaster.setOrderAmount(new BigDecimal(123.76));

        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 15);
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(openid, request);
        System.out.println(result);
    }
}