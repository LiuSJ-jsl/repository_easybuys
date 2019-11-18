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

    @RequestMapping("/buycarthree")
    public String buycarthree(Model model) {
        return "BuyCar_Three";
    }
<<<<<<< HEAD
=======

    @RequestMapping("/buycar")
    public String buycar(Model model) {
        return "BuyCar";
    }
>>>>>>> b04f49128bc12616b38a9ccebae7c705fdcf58d8
}
