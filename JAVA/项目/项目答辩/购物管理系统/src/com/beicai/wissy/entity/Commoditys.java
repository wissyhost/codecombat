package com.beicai.wissy.entity;

import java.util.ArrayList;

/**
 * Created by wissy on 2015/11/19.
 */
public class Commoditys {
    //封装商品列表
    //单例模式

    private static ArrayList<Commodity> commodities = new ArrayList<Commodity>();

    private Commoditys() {
    }

    public static ArrayList<Commodity> getCommodities() {
        return commodities;
    }
}
