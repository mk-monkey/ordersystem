package com.mkmonkey.sell.dao;

import com.mkmonkey.sell.Bo.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Class Name: SellerInfoDao
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 08:54
 **/
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
