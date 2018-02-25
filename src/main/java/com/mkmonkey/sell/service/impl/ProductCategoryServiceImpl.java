package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.Bo.ProductCategory;
import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.dao.ProductInfoDao;
import com.mkmonkey.sell.dao.productCategoryDao;
import com.mkmonkey.sell.dto.CartDTO;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @Class Name: ProductCategoryServiceImpl
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-25 20:23
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private productCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }


}
