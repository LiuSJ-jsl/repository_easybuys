package com.htkj.subject.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.htkj.subject.dao.LoginDao;
import com.htkj.subject.entity.LoginUser;
import com.htkj.verify.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 登录的controller
 * @Author: LiuSJ
 * @date: 2019/10/19 8:42
 */
@RestController
public class LoginController {

    @PostMapping(value = "/list2")
    @ResponseBody
    public String list2(@RequestParam("password") String l_pwd) {
        String ids1 = l_pwd;
        System.out.println(ids1);
        return "success";
    }

    @Autowired
    public LoginDao loginDao;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    @ResponseBody
    public ModelAndView login(ModelAndView modelAndView, @Valid LoginUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String mobile = user.getMobile();
        String password = user.getPassword();
        System.err.println("password:" + password);

        LoginUser loginUser = loginDao.login(mobile, password);
        if (loginUser == null) {
            System.err.println("查询的数据为空");
            modelAndView.addObject("error", "查询不到该账户请核对！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        System.err.println("查询成功");
        modelAndView.addObject("userName", loginUser.getUserName());
        modelAndView.setViewName("redirect:/product");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("regist");
        return modelAndView;
    }

    @GetMapping("/registerUser")
    public ModelAndView registerUser(ModelAndView modelAndView) {
        modelAndView.setViewName("regist");
        return modelAndView;
    }

    @PostMapping("/registerUser")
    @ResponseBody
    public ModelAndView registerUser(ModelAndView modelAndView, @Valid LoginUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("regist");
            return modelAndView;
        }
        int sex = user.getSex();
        String vcode = user.getVcode();
        System.out.println("手机号：" + user.getMobile());
        System.out.println("性别：" + sex);
        System.out.println("验证码：" + vcode);

        if (vcode == null || "".equals(vcode)) {
            modelAndView.addObject("error", "请填写你的验证码");
            modelAndView.setViewName("regist");
            return modelAndView;
        }
        LoginUser userByMobil = loginDao.getMobile(user.getMobile());

        if (userByMobil != null) {
            modelAndView.addObject("error", "当前手机号已注册");
            modelAndView.setViewName("regist");
            return modelAndView;
        }

        int loginUser = loginDao.addUser(user);
        if (loginUser == 0) {
            System.err.println("null");
            modelAndView.addObject("error", "请检查你的信息是否完整");
            modelAndView.setViewName("regist");
            return modelAndView;
        }
        modelAndView.addObject("user", loginUser);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @RequestMapping("/verify")
    @ResponseBody
    public String getVerify(@Valid LoginUser user, BindingResult bindingResult) {
        String sms = SmsUtils.getSsm(user.getMobile());
        String vcode = user.getVcode();
        System.out.println("手机号：" + user.getMobile());
        System.out.println("sms：" + sms);
        System.out.println("验证码：" + vcode);
        return sms;
    }
}
