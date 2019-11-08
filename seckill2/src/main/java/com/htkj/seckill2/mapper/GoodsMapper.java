package com.htkj.seckill2.mapper;

import com.htkj.seckill2.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:50
 */
public interface GoodsMapper {
    /**
     * @MethodName: updateGoodsCount
     * @Description: 减掉商品库存——悲观锁
     * @author LiuShanJie
     * @Param [goods]
     * @date 2019/10/30 14:51
     * @return int
     */
    @Update("UPDATE `seckill`.`seckill_goods` SET `name` = 'iphone X', `count` = #{goods.count}, `sale` = #{goods" +
            ".sale}, `version` = 0 WHERE `id` = 1 ;")//for update
    int updateGoodsCount(@Param("goods") Goods goods);

    /**
     * @MethodName: updateGoodsCountOptimisticLock
     * @Description: 减掉商品库存——乐观锁
     * @author LiuShanJie
     * @Param [goods, version]
     * @date 2019/10/30 14:51
     * @return int
     */
    @Update("UPDATE `seckill`.`seckill_goods` SET `name` = 'iphone X', `count` = #{goods.count}, `sale` = #{goods.sale}, `version` = #{goods.version}+1 WHERE `id` = #{goods.id} and version = #{updateVersion};")
    int updateGoodsCountOptimisticLock(@Param("goods") Goods goods, @Param("updateVersion") int version);

    /**
     * @MethodName: getGoods
     * @Description: 查询商品
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/30 14:51
     * @return com.htkj.seckill2.entity.Goods
     */
    @Select("select `id`, `name`, `count`, `sale`, `version` from seckill_goods where id = 1 for update;")
    Goods getGoods();
}
