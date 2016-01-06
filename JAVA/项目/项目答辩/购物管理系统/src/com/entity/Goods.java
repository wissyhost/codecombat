package com.entity;

import java.io.Serializable;

/**
 * Created by wissy on 2015/11/19.
 */
public class Goods implements Serializable {
    private  String name;
    private float price;

    @Override
    public String toString() {
        return "商品名称:'" + name +
                ", 价格=" + price +
                '\n';
    }
    public Goods() {
    }
    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
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

}
