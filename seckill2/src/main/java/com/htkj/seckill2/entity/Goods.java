package com.htkj.seckill2.entity;

/**
 * @Description:
 * @Author: LiuSJ
 * @date: 2019/10/30 14:47
 */
public class Goods {
    private int id;
    private String name;
    private int count;
    private int sale;
    private int version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", sale=" + sale +
                ", version=" + version +
                '}' + "\n";
    }
}
