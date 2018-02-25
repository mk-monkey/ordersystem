package com.mkmonkey.sell.service.impl;

import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.dao.ProductInfoDao;
import com.mkmonkey.sell.dto.CartDTO;
import com.mkmonkey.sell.enums.ProductStatusEnum;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    //加库存
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODEUCT_NO_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODEUCT_SROCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }

    }

    // 减库存
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODEUCT_NO_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODEUCT_SROCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }

    //上架产品
    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODEUCT_NO_EXIST);
        }
        if (productInfo.getProductStatus().equals(ProductStatusEnum.UP.getCode())) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return productInfoDao.save(productInfo);
    }

    //下架产品
    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = findOne(productId);
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODEUCT_NO_EXIST);
        }
        if (productInfo.getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return productInfoDao.save(productInfo);
    }
}
