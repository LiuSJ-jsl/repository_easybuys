package com.htkj.subject.dao;

import com.htkj.subject.entity.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Description: 登陆的DAO
 * @Author: LiuSJ
 * @date: 2019/10/18 11:58
 */
@Component
public interface LoginDao {
    /**
     * @return com.htkj.easybuy_entity.entity.LoginUser
     * @MethodName: login
     * @Description: 登录
     * @author LiuShanJie
     * @Param [mobile, password]
     * @date 2019/10/19 8:40
     */
    LoginUser login(@Param("mobile") String mobile, @Param("password") String password);

    /**
     * @return com.htkj.subject.entity.LoginUser
     * @MethodName: getMobile
     * @Description: 查询该用户是否注册
     * @author LiuShanJie
     * @Param [mobile]
     * @date 2019/10/23 16:20
     */
    LoginUser getMobile(String mobile);

    /**
     * @return com.htkj.easybuy_entity.entity.LoginUser
     * @MethodName: addUser(注册)
     * @Description: 添加用户
     * @author LiuShanJie
     * @Param [loginUser]
     * @date 2019/10/21 17:17
     */
    int addUser(LoginUser loginUser);
}
