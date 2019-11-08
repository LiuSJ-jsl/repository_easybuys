package com.htkj.seckill2.service;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:53
 */
public interface OrderService {
    /**
     * @return int
     * @MethodName: insertOrder
     * @Description: 生成订单
     * @author LiuShanJie
     * @Param [name, createTime]
     * @date 2019/10/30 14:55
     */
    int insertOrder(String name, String createTime);

    /**
     * @return void
     * @MethodName: seckillPessimism
     * @Description: 悲观锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:55
     */
    void seckillPessimism() throws Exception;

    /**
     * @return void
     * @MethodName: seckillOptimistic
     * @Description: 不重试乐观锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:55
     */
    void seckillOptimistic();

    /**
     * @return int
     * @MethodName: seckillWithOptimistic
     * @Description: 会重试的乐观锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:55
     */
    int seckillWithOptimistic();

    /**
     * @return void
     * @MethodName: seckill
     * @Description: 无锁
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:55
     */
    void seckill();

    /**
     * @return void
     * @MethodName: seckillwithRedis
     * @Description: 使用redis原子操作保障原子性
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:55
     */
    void seckillwithRedis();
}
