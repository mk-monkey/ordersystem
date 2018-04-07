package com.mkmonkey.sell.controller;

import com.mkmonkey.sell.Bo.ProductCategory;
import com.mkmonkey.sell.Bo.ProductInfo;
import com.mkmonkey.sell.excrption.SellException;
import com.mkmonkey.sell.from.CategoryForm;
import com.mkmonkey.sell.from.ProductForm;
import com.mkmonkey.sell.service.ProductCategoryService;
import com.mkmonkey.sell.utils.Keyutil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Class Name: SellerCategoryControllrt
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-02-24 07:54
 **/
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryControllrt {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * @Title: list //方法名
     * @Description: TODO
     * @Param: [map]  //参数
     * @return: org.springframework.web.servlet.ModelAndView //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午7:58
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = productCategoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String,
            Object> map) {
        if (!StringUtils.isEmpty(categoryId)) {
            ProductCategory category = productCategoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("/category/index", map);
    }


    /**
     * @Title: save //方法名
     * @Description: 修改/添加类目
     * @Param: [categoryForm, bindingResult, map]  //参数
     * @return: org.springframework.web.servlet.ModelAndView //返回值
     * @Author: MK monkey
     * @Date: 2018/2/24 上午8:14
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult bindingResult, Map<String, Object> map) {
        map.put("url", "/sell/seller/category/index");
        ProductCategory category = new ProductCategory();
        if (bindingResult.hasErrors()) {
            map.put("smg", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("common/error", map);
        }
        try {
            if (categoryForm.getCategoryId() != null){
                category = productCategoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, category);
            productCategoryService.save(category);
        } catch (SellException e) {
            map.put("smg", e.getMessage());
            return new ModelAndView("common/error", map);
        }

        return new ModelAndView("common/success", map);
    }

}
