package com.htkj.subject.mapper;

import com.htkj.subject.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/13 8:57
 */
public interface OrderMapper {
    /**
     * @param [order]
     * @return int
     * @MethodName: addOrder
     * @Description: 订单
     * @author LiuShanJie
     * @date 2019/11/11 11:03
     */
    @Insert("insert into easybuy.easybuy_order (id,userId,userAddress,createTime,cost,serialNumber,sid,number,gid)value(default,51,#{order.userAddress},NOW(),120.0,#{order.serialNumber},#{order.sid},#{order.number},1)")
    int addOrder(@Param("order") Order order);
}
