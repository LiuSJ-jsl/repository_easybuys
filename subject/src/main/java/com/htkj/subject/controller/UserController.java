package com.htkj.subject.controller;

import com.htkj.subject.entity.LoginUser;
import com.htkj.subject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/12/19 9:04
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/personage")
    public String getUser(Model model) {
        LoginUser user = userMapper.getUser(50);
        model.addAttribute("user", user);
        return "personage";
    }
}
