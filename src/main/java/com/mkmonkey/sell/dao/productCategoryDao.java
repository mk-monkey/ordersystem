package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.ProductCategory;
import com.mkmonkey.sell.Bo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Class Name: productCategoryDao
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-24 22:11
 **/
public interface productCategoryDao extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
