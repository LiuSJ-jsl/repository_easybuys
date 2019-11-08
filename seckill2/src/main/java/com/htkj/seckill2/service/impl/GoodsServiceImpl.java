package com.htkj.seckill2.service.impl;

import com.htkj.seckill2.entity.Goods;
import com.htkj.seckill2.mapper.GoodsMapper;
import com.htkj.seckill2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:54
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @param goods
     * @return int
     * @MethodName: updateGoodsCount
     * @Description: 减掉商品库存——悲观锁
     * @author LiuShanJie
     * @Param [goods]
     * @date 2019/10/30 14:52
     */
    @Override
    public int updateGoodsCount(Goods goods) {
        return goodsMapper.updateGoodsCount(goods);
    }

    /**
     * @param goods
     * @param version
     * @return int
     * @MethodName: updateGoodsCountOptimisticLock
     * @Description: 减掉商品库存——乐观锁
     * @author LiuShanJie
     * @Param [goods, version]
     * @date 2019/10/30 14:52
     */
    @Override
    public int updateGoodsCountOptimisticLock(Goods goods, int version) {
        return goodsMapper.updateGoodsCountOptimisticLock(goods, version);
    }

    /**
     * @return com.htkj.seckill2.entity.Goods
     * @MethodName: getGoods
     * @Description: 查询商品
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:53
     */
    @Override
    public Goods getGoods() {
        return goodsMapper.getGoods();
    }
}
