package com.mkmonkey.sell.service;

import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Class Name: ProductInfoService
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 17:53
 **/
public interface ProductInfoService {
    /**
     * @Title: findOne //方法名
     * @Description: 根据 id 查询一个商品
     * @Param: [productId]  //参数
     * @return: com.mkmonkey.sell.Bo.ProductInfo //返回值
     * @Author: MK monkey
     * @Date: 2018/1/28 下午5:55
     */
    ProductInfo findOne(String productId);

    /**
     * @Title: findupAll //方法名
     * @Description: 查询所有商品的 信息
     * @Param: []  //参数
     * @return: java.util.List<com.mkmonkey.sell.Bo.ProductInfo> //返回值
     * @Author: MK monkey
     * @Date: 2018/1/28 下午5:56
     */
    List<ProductInfo> findUpAll();

    /**
     * @Title: findAll //方法名
     * @Description: 查询分页
     * @Param: [pageable]  //参数
     * @return: java.util.List<com.mkmonkey.sell.Bo.ProductInfo> //返回值
     * @Author: MK monkey
     * @Date: 2018/1/28 下午5:57
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * @Title: save //方法名
     * @Description: 添加一个信息
     * @Param: [productInfo]  //参数
     * @return: com.mkmonkey.sell.Bo.ProductInfo //返回值
     * @Author: MK monkey
     * @Date: 2018/1/28 下午5:58
     */
    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //上架
    ProductInfo offSale(String productId);
}
