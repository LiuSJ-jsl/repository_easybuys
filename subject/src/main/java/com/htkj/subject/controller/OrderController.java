package com.htkj.subject.controller;

import com.htkj.subject.entity.Order;
import com.htkj.subject.mapper.OrderMapper;
import com.htkj.subject.util.GetRundom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/11 10:55
 */
@Controller
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @RequestMapping("/order")
    public String single(Model model, @Valid Integer id, @Valid Float price) {
        GetRundom getRundom = new GetRundom();
        System.err.println("id" + id);
        System.err.println("price" + price);
        Order order = new Order();
        order.setUserAddress("北京市花园路小区");
        order.setSerialNumber(getRundom.getRundom(32));
        order.setSid(733);
        order.setNumber(1);
        orderMapper.addOrder(order);
        //map.addAttribute("id", 51);
        return "redirect:/getOrder?id=" + 51;
    }

    @RequestMapping("/getOrder")
    public String getOrder(Model model, @Valid Integer id) {
        Order order = orderMapper.getOrder(id);
        model.addAttribute("order", order);
        return "order";
    }
}
