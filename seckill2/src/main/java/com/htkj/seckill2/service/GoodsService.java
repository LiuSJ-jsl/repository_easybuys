package com.htkj.seckill2.service;

import com.htkj.seckill2.entity.Goods;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:52
 */
public interface GoodsService {
    /**
     * @MethodName: updateGoodsCount
     * @Description: 减掉商品库存——悲观锁
     * @author LiuShanJie
     * @Param [goods]
     * @date 2019/10/30 14:52
     * @return int
     */
    int updateGoodsCount(Goods goods);

    /**
     * @MethodName: updateGoodsCountOptimisticLock
     * @Description: 减掉商品库存——乐观锁
     * @author LiuShanJie
     * @Param [goods, version]
     * @date 2019/10/30 14:52
     * @return int
     */
    int updateGoodsCountOptimisticLock(Goods goods, int version);

    /**
     * @MethodName: getGoods
     * @Description: 查询商品
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:53
     * @return com.htkj.seckill2.entity.Goods
     */
    Goods getGoods();
}
