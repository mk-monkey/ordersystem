package com.mkmonkey.sell.controller;

import com.mkmonkey.sell.Bo.ProductCategory;
import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.enums.ResultEnum;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.from.ProductForm;
import com.mkmonkey.sell.service.ProductCategoryService;
import com.mkmonkey.sell.service.ProductInfoService;
import com.mkmonkey.sell.utils.Keyutil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Class Name: SellerProductController
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 05:33
 **/
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;


    //查询商品列表
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(
            value = "size", defaultValue = "10") Integer size, Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currebtPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    //上架商品
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId, Map<String, Object> map) {
        map.put("url", "/sell/seller/product/list");
        try {
            ProductInfo productInfo = productInfoService.onSale(productId);
        } catch (Exception e) {
            log.error("[买家端-商品上架] 商品上架失败");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.PRODUCT_UP_SUCCESS.getMessage());
        return new ModelAndView("success", map);
    }

    //下架商品
    @RequestMapping("/off_sale")
    public ModelAndView off_sale(@RequestParam("productId") String productId, Map<String, Object> map) {
        map.put("url", "/sell/seller/product/list");
        try {
            ProductInfo productInfo = productInfoService.offSale(productId);
        } catch (Exception e) {
            log.error("[买家端-商品上架] 商品上架失败");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.PRODUCT_DONW_SUCCESS.getMessage());
        return new ModelAndView("success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId, Map<String,
            Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("/product/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult, Map<String, Object> map) {
        map.put("url", "/sell/seller/product/index");
        ProductInfo productInfo = new ProductInfo();
        if (bindingResult.hasErrors()) {
            map.put("smg", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("common/error", map);
        }
        try {
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productInfoService.findOne(productForm.getProductId());
            } else {
                productForm.setProductId(Keyutil.genProductKey());
            }
            BeanUtils.copyProperties(productForm, productInfo);
            productInfoService.save(productInfo);
        } catch (SellException e) {
            map.put("smg", e.getMessage());
            return new ModelAndView("common/error", map);
        }

        return new ModelAndView("common/success", map);
    }
}
