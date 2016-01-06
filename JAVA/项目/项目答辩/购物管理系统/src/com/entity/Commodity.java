package com.entity;

import java.util.ArrayList;

/**
 * Created by wissy on 2015/11/19.
 */
public class Commodity {
    //单例
    private static ArrayList<Goodss> Commodityslist= new ArrayList<Goodss>();
    private Commodity() {
    }
    public static ArrayList<Goodss> getCommodityslist(){
        return Commodityslist;
    }
}
