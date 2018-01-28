package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.Bo.ProductCategory;
import com.mkmonkey.sell.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(1);
        System.out.println(productCategory);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = productCategoryService.findAll();
        Assert.assertNotEquals(0, list.size());

    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5,6));
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(RandomString(5));
        productCategory.setCategoryType(RandomInteger(4));
        ProductCategory m = productCategoryService.save(productCategory);
        Assert.assertNotNull(m);
    }


    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    public static Integer RandomInteger(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(10);
            buf.append(str.charAt(num));
        }
        int a = Integer.valueOf(buf.toString());
        return a;
    }
}