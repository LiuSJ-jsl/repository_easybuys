package com.htkj.subject.controller;

import com.htkj.subject.dao.ProductDao;
import com.htkj.subject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 首页的controller
 * @Author: LiuSJ
 * @date: 2019/10/21 15:59
 */
@Controller
public class ProductController {

    @Autowired
    public ProductDao productDao;

    @RequestMapping("/product")
    public String product(ModelMap map, HttpServletRequest request) {
        List<Product> productList = productDao.getProductByIsDelete();
        HttpSession session = request.getSession();
        Object userName = session.getAttribute("userName");
        map.addAttribute("userName", userName);
        map.addAttribute("productList", productList);
        return "products";
    }

    @RequestMapping("/single")
    public String single(ModelMap map, @Valid int id) {
        System.out.println(id);
        Product product = productDao.getProductById(id);
        map.addAttribute("productById", product);
        return "particulars";
    }
}
