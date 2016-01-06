package com.beicai.wissy.service;

import com.beicai.wissy.MyException.DataOutOfBoundException;
import com.beicai.wissy.entity.Commodity;
import com.beicai.wissy.entity.Commoditys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by wissy on 2015/11/18.
 */
public class CommodityManagement {
    Scanner input = new Scanner(System.in);
//    获取商品列表
    ArrayList<Commodity> commodities= Commoditys.getCommodities();
    //初始化商品
    public void initial() throws DataOutOfBoundException{
        commodities.add(new Commodity(7999,"戴尔电脑", 25.6f,true));
        commodities.add(new Commodity(366,"3小时能量", 5.6f,true));
        commodities.add(new Commodity(1,"红米2A", 799f,true));
        commodities.add(new Commodity(12,"鼠标", 25.6f,true));
        commodities.add(new Commodity(79,"衣服", 25.6f,true));
        commodities.add(new Commodity(2,"哈哈", 25.6f,true));
    }
    //获取商品列表
    public void getComoditiesList(){
        Iterator<Commodity> it=commodities.iterator();
        while (it.hasNext()){
            Commodity tempCommoditi=it.next();
            System.out.println(tempCommoditi.toString());
        }
    }
//添加商品
    public boolean addComnodity() throws DataOutOfBoundException  {
        System.out.println("输入商品名称:");
        String name = input.next();
        for (Commodity tempCom :
                commodities) {
            if ("Author".equals(tempCom.getCommodityName())) {
                return false;//有相同的名字,
            }
        }
        System.out.println("输入商品数量:");
        int number = input.nextInt();
        System.out.println("输入商品价格:");
        float price = input.nextFloat();
        commodities.add(new Commodity(number, name, price, true));
        return true;
    }
    //转换商品状态
//    public boolean ChangState(){
//        System.out.println("输入商品名称:");
//        String name =input.next();
//        for (Commodity tempCom : commodities) {
//            if (!"name".equals(tempCom.getCommodityName())) {
//                Commodity cc=tempCom;
//                commodities.remove(tempCom);
//                cc.setCommdityState(cc.isCommdityState()?false:true);
//                System.out.println("商品"+tempCom.getCommodityName()+"由"+(tempCom.isCommdityState()?"可以购买":"不可以购买")
//                        +"改为"+(tempCom.isCommdityState()?"不可以购买":"可以购买"));
//                return true;//有那个名字,
////            }
//        }
//        System.out.println("没有"+name+"商品,无法更改状态");
//        return false;
//    }
}
