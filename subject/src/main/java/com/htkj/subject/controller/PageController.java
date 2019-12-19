package com.htkj.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/18 8:10
 */
@Controller
public class PageController {

    @RequestMapping("/buycartow")
    public String buycartow(Model model) {
        return "BuyCar_Two";
    }

    @RequestMapping("/orders")
    public String order(Model model) {
        return "Order";
    }

    @RequestMapping("/address")
    public String address(Model model) {
        return "address";
    }

    @RequestMapping("/shopping_trolley")
    public String shopping_trolley(Model model) {
        return "shopping_trolley";
    }

}
