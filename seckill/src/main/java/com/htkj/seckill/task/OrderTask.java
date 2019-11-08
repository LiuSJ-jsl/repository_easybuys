package com.htkj.seckill.task;

import com.htkj.seckill.queue.RequestQueue;
import com.htkj.seckill.vo.AsyncVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/28 9:09
 */
@Component
public class OrderTask extends Thread {
    @Autowired
    private RequestQueue queue;

    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                AsyncVo<String, Object> vo = queue.getOrderQueue().take();
                System.out.println("[ OrderTask ]开始处理订单");

                String params = vo.getParams();
                Thread.sleep(3000);
                Map<String, Object> map = new HashMap<>();
                map.put("params", params);
                map.put("time", System.currentTimeMillis());

                vo.getResult().setResult(map);

                System.out.println("[ OrderTask ]订单处理完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
            }

        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
