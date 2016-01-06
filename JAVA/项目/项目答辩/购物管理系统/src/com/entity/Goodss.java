package com.entity;

import java.io.Serializable;

/**
 * Created by wissy on 2015/11/19.
 */
public class Goodss extends Goods implements Serializable {
    private int number;
    private boolean state;

    public Goodss() {
        super();
    }

    public Goodss(String name, float price, int number, boolean state) {
        super(name, price);
        this.number = number;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "商品名称:" + super.getName()+//(super.getName().length()>8?"":super.getName().length()>4?"":"\t\t")+
                ", 数量:" + getNumber() +
                ", 价格:" + super.getPrice() +
                ", 状态:" + (isState()&&getNumber()>0?"可购买":"不可以购买");
    }

}
