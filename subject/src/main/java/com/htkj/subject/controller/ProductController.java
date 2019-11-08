package com.htkj.subject.controller;

import com.htkj.subject.dao.ProductDao;
import com.htkj.subject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 首页的controller
 * @Author: LiuSJ
 * @date: 2019/10/21 15:59
 */
@RestController
public class ProductController {

    @Autowired
    public ProductDao productDao;


    @RequestMapping("/product")
    public ModelAndView product(ModelAndView modelAndView, @Valid String userName) {
        List<Product> productList = productDao.getProductByIsDelete();
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("userName", userName);
        modelAndView.setViewName("products");
        return modelAndView;
    }
}
