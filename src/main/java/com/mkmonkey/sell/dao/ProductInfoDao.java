package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Class Name: ProductInfoDao
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-25 21:47
 **/
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
