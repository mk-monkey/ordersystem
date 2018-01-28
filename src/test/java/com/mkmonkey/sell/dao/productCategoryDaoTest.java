package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Transient;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class productCategoryDaoTest {

    @Autowired
    private productCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void seveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("xiaoshazi");
        productCategory.setCategoryType(1983);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null, result);

    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotNull(result);
    }
}