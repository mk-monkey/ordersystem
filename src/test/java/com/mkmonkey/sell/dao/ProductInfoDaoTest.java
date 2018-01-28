package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.service.impl.ProductCategoryServiceImplTest;
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
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        //生成订单编号
        productInfo.setProductId(String.valueOf(ProductCategoryServiceImplTest.RandomInteger(7)));
        productInfo.setProductName("三只松鼠");
        //这是单价 需要转义成 bigdecimal 类型的
        productInfo.setProductPrice(new BigDecimal(198));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("就好吃");
        productInfo.setProductIcon("https://www.sanzhisongshu.com");
        productInfo.setProductStatus(0);
        //生成类目编号  正常应该是类目的编号
        productInfo.setCategoryType(ProductCategoryServiceImplTest.RandomInteger(5));

        ProductInfo s = productInfoDao.save(productInfo);
        Assert.assertNotNull(s);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoDao.findByProductStatus(0);
        System.out.println(list);
        Assert.assertNotEquals(0, list.size());
    }


 /*   public static Integer RandomInteger(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(10);
            buf.append(str.charAt(num));
        }
        int a = Integer.valueOf(buf.toString());
        return a;
    }*/
}