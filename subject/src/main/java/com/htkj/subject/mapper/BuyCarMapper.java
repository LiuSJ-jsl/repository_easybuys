package com.htkj.subject.mapper;

import com.htkj.subject.entity.BuyCar;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuyCarMapper {
    @Select("select * from easybuy.easybuy_buycar where uid = #{uid}")
    List<BuyCar> getBuyCarById(@Param("uid") int uid);

}
