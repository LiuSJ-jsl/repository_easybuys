package com.htkj.seckill.controller;

import com.htkj.seckill.queue.RequestQueue;
import com.htkj.seckill.vo.AsyncVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/28 9:10
 */
@RestController
public class OrderController {
    @Autowired
    private RequestQueue queue;

    @GetMapping("/order")
    public DeferredResult<Object> order(String number) throws InterruptedException {
        System.out.println("[ OrderController ] 接到下单请求");
        System.out.println("当前待处理订单数： " + queue.getOrderQueue().size());

        AsyncVo<String, Object> vo = new AsyncVo<>();
        DeferredResult<Object> result = new DeferredResult<>();

        vo.setParams("1000");
        vo.setResult(result);

        queue.getOrderQueue().put(vo);
        System.out.println("[ OrderController ] 返回下单结果");
        return result;
    }

}
