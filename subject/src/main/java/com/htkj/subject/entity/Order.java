package com.htkj.subject.entity;

import java.util.Date;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/11 10:04
 */
public class Order {
    int id;
    int userId;
    String userAddress;
    Date createTime;
    float cost;
    String serialNumber;
    int sid;
    int number;
    int gid;
    Date MaxDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Date getMaxDate() {
        return MaxDate;
    }

    public void setMaxDate(Date maxDate) {
        MaxDate = maxDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", userAddress='" + userAddress + '\'' +
                ", createTime=" + createTime +
                ", cost=" + cost +
                ", serialNumber='" + serialNumber + '\'' +
                ", sid=" + sid +
                ", number=" + number +
                ", gid=" + gid +
                ", MaxDate=" + MaxDate +
                '}';
    }
}
