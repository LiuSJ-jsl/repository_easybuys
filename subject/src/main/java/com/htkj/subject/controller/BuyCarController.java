package com.htkj.subject.controller;

import com.htkj.subject.entity.BuyCar;
import com.htkj.subject.mapper.BuyCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/20 16:23
 */
@Controller
public class BuyCarController {

    @Autowired
    public BuyCarMapper buyCarMapper;

    @RequestMapping("/buycar")
    public String buycar(Model model, int uid) {
        System.out.println("uid:" + uid);
        List<BuyCar> getBuyCarById = buyCarMapper.getBuyCarById(uid);
        model.addAttribute("getBuyCar", getBuyCarById);
        return "BuyCar";
    }

    @RequestMapping("/buycarthree")
    public String buycarthree(Model model) {
        return "BuyCar_Three";
    }
}
