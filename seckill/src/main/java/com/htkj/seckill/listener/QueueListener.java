package com.htkj.seckill.listener;

import com.htkj.seckill.task.OrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/28 9:10
 */
@Component
public class QueueListener {
    @Autowired
    private OrderTask orderTask;

    /**
     * 初始化时启动监听请求队列
     */
    @PostConstruct
    public void init() {
        orderTask.start();
    }

    /**
     * 销毁容器时停止监听任务
     */
    @PreDestroy
    public void destory() {
        orderTask.setRunning(false);
    }
}
