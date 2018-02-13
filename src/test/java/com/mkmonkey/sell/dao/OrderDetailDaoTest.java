package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("223456");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://www.baidu.com");
        orderDetail.setProductId("1133915");
        orderDetail.setProductName("三只松鼠");
        orderDetail.setProductPrice(new BigDecimal(198.22));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetails=orderDetailDao.findByOrderId("123456");
        System.out.println(orderDetails);
    }
}