package com.htkj.subject.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Description: 登录的实体类
 * @Author: LiuSJ
 * @date: 2019/10/18 11:58
 */
public class LoginUser {
    int id;
    String userName;
    //    @Size(min = 6, max = 18, message = "密码的长度为6-18位，请注意！")
    String password;
    int sex;
    //    @Email(message = "请检查你的邮箱是否正确！")
    String email;
    //    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "请验证你的11位手机号！")
    String mobile;
    int type;
    String vcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                ", vcode='" + vcode + '\'' +
                '}' + "\n";
    }
}
