package com.htkj.subject.controller;

import com.htkj.subject.entity.LoginUser;
import com.htkj.subject.mapper.LoginMapper;
import com.htkj.verify.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Description: 登录的controller
 * @Author: LiuSJ
 * @date: 2019/10/19 8:42
 */
@Controller
public class LoginController {

    @Autowired
    public LoginMapper loginMapper;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(ModelMap map, @Valid LoginUser user, HttpServletRequest request) {
        String mobile = user.getMobile();
        String password = user.getPassword();
        System.err.println("password:" + password);
        System.err.println("mobile:" + mobile);

        LoginUser loginUser = loginMapper.login(mobile, password);
        if (loginUser == null) {
            System.err.println("查询的数据为空");
            map.addAttribute("error", "查询不到该账户请核对！");
            return "logins";
        }
        System.err.println("查询成功");
        //return "redirect:/product?userName=" + loginUser.getUserName();
        HttpSession session = request.getSession();
        session.setAttribute("userName", loginUser.getUserName());
        //map.addAttribute("userName", loginUser.getUserName());
        return "redirect:/product";
    }

    @GetMapping("/registerUser")
    public String registerUser() {
        return "regist";
    }

    @PostMapping("/registerUser")
    //@ResponseBody
    public String registerUser(ModelMap map, @Valid LoginUser user) {
        int sex = user.getSex();
        String vcode = user.getVcode();
        System.out.println("手机号：" + user.getMobile());
        System.out.println("性别：" + sex);
        System.out.println("验证码：" + vcode);

        if (vcode == null || "".equals(vcode)) {
            map.addAttribute("error", "请填写你的验证码");
            return "regist";
        }
        LoginUser userByMobil = loginMapper.getMobile(user.getMobile());

        if (userByMobil != null) {
            map.addAttribute("error", "当前手机号已注册");
            return "regist";
        }

        int loginUser = loginMapper.addUser(user);
        if (loginUser == 0) {
            System.err.println("null");
            map.addAttribute("error", "请检查你的信息是否完整");
            return "regist";
        }
        map.addAttribute("user", loginUser);
        return "redirect:/login";
    }

    @RequestMapping("/verify")
    @ResponseBody
    public String getVerify(@Valid LoginUser user) {
        String sms = SmsUtils.getSsm(user.getMobile());
        String vcode = user.getVcode();
        System.out.println("手机号：" + user.getMobile());
        System.out.println("sms：" + sms);
        System.out.println("验证码：" + vcode);
        return sms;
    }
}
