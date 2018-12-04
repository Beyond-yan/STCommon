package com.beyond.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @Author 闫波
 * @Date 2018/12/3 0014 12:39
 **/

@TableName("goods")
public class Goods {
    private int id;
    private String name;
    private double price;
    private String des;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
