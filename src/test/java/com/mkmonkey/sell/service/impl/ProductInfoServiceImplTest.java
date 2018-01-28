package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.dao.ProductInfoDao;
import com.mkmonkey.sell.enums.ProductStatusEnum;
import com.mkmonkey.sell.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoDao;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoDao.findOne("1133915");
        Assert.assertEquals("1133915", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productInfoDao.findUpAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> page = productInfoDao.findAll(request);
//        System.out.println(page);
        Assert.assertNotEquals(0, page.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        //生成订单编号
        productInfo.setProductId(String.valueOf(ProductCategoryServiceImplTest.RandomInteger(7)));
        productInfo.setProductName("良品铺子");
        //这是单价 需要转义成 bigdecimal 类型的
        productInfo.setProductPrice(new BigDecimal(288));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("杨紫就是漂亮");
        productInfo.setProductIcon("https://www.liangpinpuzi.com");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        //生成类目编号  正常应该是类目的编号
        productInfo.setCategoryType(2);

        ProductInfo s = productInfoDao.save(productInfo);
        Assert.assertNotNull(s);
    }
}