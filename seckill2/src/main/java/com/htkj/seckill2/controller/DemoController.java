package com.htkj.seckill2.controller;

import com.htkj.seckill2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 15:10
 */
@Controller
@EnableAutoConfiguration
public class DemoController {
    @Autowired
    private OrderService orderService;

    /**
     * @return java.lang.String
     * @MethodName: nginx
     * @Description: 访问nginx
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 15:11
     */
    @RequestMapping("/nginx")
    @ResponseBody
    public String nginx() {
        RestTemplate restTemplate = new RestTemplate();
        String conent = restTemplate.getForObject("http://127.0.0.1/", String.class);
        if (conent.contains("Welcome to nginx!")) {
            return "success";
        }
        return null;
    }

    /**
     * @return void
     * @MethodName: seckill
     * @Description: 无锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 15:11
     */
    @RequestMapping(value = "/seckill")
    @ResponseBody
    public void seckill() {
        orderService.seckill();
    }

    /**
     * @return void
     * @MethodName: seckillPessimisticLock
     * @Description: 悲观锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 15:11
     */
    @RequestMapping(value = "/seckillPessimisticLock")
    @ResponseBody
    public void seckillPessimisticLock() {
        try {
            orderService.seckillPessimism();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @MethodName: OptimisticLock
     * @Description: 乐观锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 15:11
     */
    @RequestMapping(value = "/seckillOptimisticLock")
    @ResponseBody
    public void OptimisticLock() {
        orderService.seckillOptimistic();
    }

    /**
     * @return void
     * @MethodName: OptimisticLockRetry
     * @Description: 失败会重试乐观锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 15:11
     */
    @RequestMapping(value = "/seckillOptimisticLockretry")
    @ResponseBody
    public void OptimisticLockRetry() {

        while (true) {
            int i = orderService.seckillWithOptimistic();
            //如果卖光了 或者卖出成功跳出循环，否者一直循环，直到卖出去为止
            if (i == -1 || i > 0) {
                break;
            }
        }
    }

    /**
     * @return void
     * @MethodName: seckillRedis
     * @Description: 使用redis原子操作保障原子性
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 15:12
     */
    @RequestMapping(value = "/seckillRedis")
    @ResponseBody
    public void seckillRedis() {
        orderService.seckillwithRedis();
    }

}
