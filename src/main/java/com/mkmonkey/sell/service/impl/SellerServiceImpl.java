package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.Bo.SellerInfo;
import com.mkmonkey.sell.dao.SellerInfoDao;
import com.mkmonkey.sell.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class Name: SellerServiceImpl
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 09:10
 **/
@Service
@Slf4j
public class SellerServiceImpl implements SellerService{
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerOPenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
