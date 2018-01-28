package com.mkmonkey.sell.controller;

import com.mkmonkey.sell.Bo.ProductCategory;
import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.Vo.ProductInofoVo;
import com.mkmonkey.sell.Vo.ProductVo;
import com.mkmonkey.sell.Vo.ResultVo;
import com.mkmonkey.sell.service.ProductCategoryService;
import com.mkmonkey.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Class Name: BuyerProductContr∂oller∂∂
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-28 18:34
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    protected ResultVo list() {
        ResultVo resultVo = new ResultVo();
        //查询所有的上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //类目查询
        List<Integer> categoryTypeList = new ArrayList<>();
        //1 for 循环拼装
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //精简方法 lambda
        List<Integer> categoryTypeList2 = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList2);
        //数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategortType(productCategory.getCategoryType());
            productVo.setCatrgoryName(productCategory.getCategoryName());
            List<ProductInofoVo> productInofoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInofoVo productInofoVo = new ProductInofoVo();
                    BeanUtils.copyProperties(productInfo, productInofoVo);
                    productInofoVoList.add(productInofoVo);
                }
            }
            productVo.setProductInofoVoList(productInofoVoList);
            productVoList.add(productVo);
        }

        resultVo.setData(productVoList);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }
}
