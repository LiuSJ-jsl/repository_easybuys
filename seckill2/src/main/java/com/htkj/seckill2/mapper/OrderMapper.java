package com.htkj.seckill2.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:51
 */
public interface OrderMapper {
    /**
     * @return int
     * @MethodName: insertOrder
     * @Description: 生成订单
     * @author LiuShanJie
     * @Param [name, createTime]
     * @date 2019/10/30 14:52
     */
    @Insert("INSERT INTO `seckill`.`seckill_order`(`custname`, `create_time`) VALUES (#{name}, #{createTime});")
    int insertOrder(@Param("name") String name, @Param("createTime") String createTime);
}
