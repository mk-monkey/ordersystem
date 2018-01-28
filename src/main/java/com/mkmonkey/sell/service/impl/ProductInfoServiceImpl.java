package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.dao.ProductInfoDao;
import com.mkmonkey.sell.enums.ProductStatusEnum;
import com.mkmonkey.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Class Name: ProductInfoServiceImpl
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 17:53
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
