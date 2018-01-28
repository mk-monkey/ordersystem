package com.mkmonkey.sell.service;

import com.mkmonkey.sell.Bo.ProductCategory;

import java.util.List;

/**
 * @Class Name: ProductCategoryService
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-25 20:23
 **/
public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
