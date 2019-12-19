package com.htkj.subject.mapper;

import com.htkj.subject.entity.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from easybuy_user where id = #{id}")
    LoginUser getUser(@Param("id") int id);
}
