package com.htkj.seckill2.entity;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:49
 */
public class Order {
    private int id;
    private String custname;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", custname='" + custname + '\'' +
                ", createTime='" + createTime + '\'' +
                '}' + "\n";
    }
}
