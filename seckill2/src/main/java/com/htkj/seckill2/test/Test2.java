package com.htkj.seckill2.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/11/1 15:57
 */
public class Test2 {
    static Boolean isEmpty = false;

    public static void main(String[] args) {
        int threadNumber = 500;//模拟多少个用户在抢
        int goodsNumber = 499;//商品数量

        // TODO Auto-generated method stub
        //线程池，无限缓存线程池
        ExecutorService excutor = Executors.newCachedThreadPool();
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        if (!jedis.exists("goods")) {
            System.out.println("无商品数据，开始添加！");
            //插入商品
            for (int i = 0; i < goodsNumber; i++) {
                jedis.lpush("goods", "1");
            }
        }//TODO 还要保证同一个用户不能秒杀两个
        Map<String, String> map = new HashMap<>();
        long length = jedis.llen("goods");
        System.out.println("商品剩余数量：" + length);
        //模拟秒杀代码
        CountDownLatch countDown = new CountDownLatch(threadNumber);
        for (int i = 0; i < threadNumber; i++) {
            final int index = i;
            excutor.execute(() -> {
                System.out.println("用户 " + index + " 开始秒杀商品！");
                //如果已经被抢完则直接拒绝后面的请求了。
                if (isEmpty) {
                    System.out.println("用户" + index + " 抱歉商品已秒杀完毕！");
                    countDown.countDown();
                    return;
                }
                Jedis checkJedis = new Jedis("localhost");
                String result = checkJedis.lpop("goods");
                //如果成功删除redis里的数据则表示抢到，如果存储数字则还需要事务控制并修改商品数字，比较影响性能，因此使用list比较好。
                if (result != null && !result.equals("")) {
                    System.out.println("用户 " + index + " 成功抢到！");
                    map.put(index + "", result);
                } else {
                    //只允许一个线程修改状态
                    synchronized (isEmpty) {
                        isEmpty = true;
                    }
                    System.out.println("用户 " + index + " 很遗憾你没有抢到，商品已秒杀完。");
                }
                checkJedis.close();
                //表示一个线程执行完毕了
                countDown.countDown();
            });
        }
        try {
            //等待所有线程执行完毕
            countDown.await();
            System.out.println("所有用户秒杀完毕，开始公布结果：");
            for (String key : map.keySet()) {
                System.out.println("恭喜用户" + key + " 成功抢到！");
            }
            System.out.println("共" + map.size() + "位用户成功抢到。");
            jedis.close();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
