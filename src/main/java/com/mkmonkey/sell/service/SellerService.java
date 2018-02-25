package com.mkmonkey.sell.service;

import com.mkmonkey.sell.Bo.SellerInfo;

/**
 * @Class Name: SellerService
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 09:09
 **/
public interface SellerService {

    SellerInfo findSellerOPenid(String openid);
}
