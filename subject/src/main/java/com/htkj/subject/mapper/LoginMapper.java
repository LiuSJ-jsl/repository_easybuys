package com.htkj.subject.mapper;

import com.htkj.subject.entity.LoginUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/13 8:36
 */
public interface LoginMapper {
    /**
     * @return com.htkj.easybuy_entity.entity.LoginUser
     * @MethodName: login
     * @Description: 登录
     * @author LiuShanJie
     * @Param [mobile, password]
     * @date 2019/10/19 8:40
     */
    @Select("select * from easybuy.easybuy_user where mobile = #{mobile} and password = #{password}")
    LoginUser login(@Param("mobile") String mobile, @Param("password") String password);

    /**
     * @return com.htkj.subject.entity.LoginUser
     * @MethodName: getMobile
     * @Description: 查询该用户是否注册
     * @author LiuShanJie
     * @Param [mobile]
     * @date 2019/10/23 16:20
     */
    @Select("select mobile from easybuy.easybuy_user where mobile = #{mobile}")
    LoginUser getMobile(@Param("mobile") String mobile);

    /**
     * @return com.htkj.easybuy_entity.entity.LoginUser
     * @MethodName: addUser(注册)
     * @Description: 添加用户
     * @author LiuShanJie
     * @Param [loginUser]
     * @date 2019/10/21 17:17
     */
    @Insert("insert into easybuy.easybuy_user value ( default,#{loginUser.userName},#{loginUser.password},#{loginUser.sex},#{loginUser.email},#{loginUser.mobile}, default)")
    int addUser(@Param("loginUser") LoginUser loginUser);
}
