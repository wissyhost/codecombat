package com.beicai.wissy.entity;

import com.beicai.wissy.MyException.DataOutOfBoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wissy on 2015/11/18.
 */
public class MemberShoppingManagement {

    private Commodity commodity;
    //总价
    private float Total;
    //购物车商品集合
    List<Commodity> Commoditylist = new ArrayList<Commodity>();

    public void initial() throws DataOutOfBoundException {
        Commoditylist.add(new Commodity(7999,"戴尔电脑", 25.6f,true));
        Commoditylist.add(new Commodity(366,"3小时能量", 5.6f,true));
        Commoditylist.add(new Commodity(1,"红米2A", 799f,true));
        Commoditylist.add(new Commodity(12,"鼠标", 25.6f,true));
        Commoditylist.add(new Commodity(79,"衣服", 25.6f,true));
        Commoditylist.add(new Commodity(2,"哈哈", 25.6f,true));
    }
    //获取商品列表
    public void getComoditiesList(){
        Iterator<Commodity> it=Commoditylist.iterator();
        while (it.hasNext()){
            Commodity tempCommoditi=it.next();
            System.out.println(tempCommoditi.toString());
        }
    }
    //返回值为ture添加成功
    public boolean addCommodityOfMyMem(Commodity commodity) {
        boolean ret = false;
        //商品状态为ture可以添加
        if (commodity.isCommdityState()) {
            ret = true;
            Commoditylist.add(commodity);
        }
        return ret;
    }
    //移除商品
    public boolean removeCommodityOfMyMem(Commodity commodity) {
        boolean ret = false;
        //商品状态为ture可以添加
        Commoditylist.remove(commodity);
        return ret;
    }

    //获取总价
    public float getTotal() {
        for (int i = 0; i < Commoditylist.size(); i++) {
            Commodity tempCom = Commoditylist.get(i);
            Total += tempCom.getCommodityPrice();
        }
        return Total;
    }
//
//
//    //单例模式,一个用户只能有一个购物车
//    private static MemberShoppingManagement msm = new MemberShoppingManagement();
//
//    private MemberShoppingManagement() {
//
//    }
//
//    public MemberShoppingManagement getMemberShoppingManagement() {
//        return msm;
//    }
//    //--------------
}
