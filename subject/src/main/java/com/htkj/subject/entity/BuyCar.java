package com.htkj.subject.entity;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/20 15:27
 */
public class BuyCar {
    int id;
    String name;
    float price;
    String fileName;
    int number;
    int uid;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "BuyCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", fileName='" + fileName + '\'' +
                ", number=" + number +
                ", uid=" + uid +
                '}';
    }
}
