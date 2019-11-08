package com.htkj.seckill2;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;


@RunWith(SpringRunner.class)
@Component
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Seckill2ApplicationTests {

    RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    private int port;

    private URL base;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);

        //测试nginx的正常请求和限流请求
        url_nginx = "http://127.0.0.1:" + port + "/nginx";
        //测试数据库-无锁
        url_nolock = "http://127.0.0.1:" + port + "/seckill";
        //测试乐观锁
        url_optimistic = "http://127.0.0.1:" + port + "/seckillOptimisticLock";
        //测试带重试的乐观锁
        url_optimisticWithRetry = "http://127.0.0.1:" + port + "/seckillOptimisticLockretry";
        //测试悲观锁
        url_pessimistic = "http://127.0.0.1:" + port + "/seckillPessimisticLock";
        //使用redis原子操作保障原子性
        url_redis = "http://127.0.0.1:" + port + "/seckillRedis";
    }


    //测试nginx的正常请求和限流请求
    String url_nginx = "http://127.0.0.1:8080/nginx";
    //测试数据库-无锁
    String url_nolock = "http://127.0.0.1:8080/seckill";
    //测试乐观锁
    String url_optimistic = "http://127.0.0.1:8080/seckillOptimisticLock";
    //测试带重试的乐观锁
    String url_optimisticWithRetry = "http://127.0.0.1:8080/seckillOptimisticLockretry";
    //测试悲观锁
    String url_pessimistic = "http://127.0.0.1:8080/seckillPessimisticLock";
    //使用redis原子操作保障原子性
    String url_redis = "http://127.0.0.1:8080/seckillRedis";

    //测试购买商品，使用200个并发
    private static final int amount = 200;
    //等所有线程都准备好再一起请求
    private CountDownLatch countDownLatch = new CountDownLatch(amount);

    @Test
    public void contextLoads() throws InterruptedException {
        System.out.println("开始卖：" + System.currentTimeMillis());
        for (int i = 0; i < amount; i++) {
            new Thread(new Request()).start();
            countDownLatch.countDown();
        }
        Thread.currentThread().sleep(100000);
    }

    public class Request implements Runnable {

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restTemplate.getForObject(url_optimisticWithRetry, String.class);
        }
    }
}
