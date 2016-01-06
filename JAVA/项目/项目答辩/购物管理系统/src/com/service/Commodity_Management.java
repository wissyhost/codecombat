package com.service;


import com.entity.Commodity;
import com.entity.Goods;
import com.entity.Goodss;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wissy on 2015/11/19.
 */
//商品管理器
public class Commodity_Management {
    //读取数据时间不合适

    //读取获取对象地址
//
//    //构造器...判断是不是第一次运行
//    public Commodity_Management() {
//
//        if (CommodityS.size()==0){
//            CommodityS=dao.read();
//        }
//    }
//获取列表
    public void list() {
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();

        for (int i = 0; i < CommodityS.size(); i++) {
            System.out.println("id:" + (i + 1) + CommodityS.get(i));
        }

    }

    //获取id的详细信息
    public Goodss idSearch(int i) {
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();
//        for (int j = 0; j <CommodityS.size(); j++) {
//
//        }
        //System.out.println("id:" + (i) + CommodityS.get(i - 1));
        if (i<=CommodityS.size()){
            return CommodityS.get(i - 1);
        }
       return null;
    }

    //获取名字查询
    public Goodss nameSearch(String name) {
        //获取商品的地址
          ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();


        for (Goodss tempGoogs : CommodityS) {
            if (tempGoogs.getName().equals(name)) {
                return tempGoogs;
            }
        }

        return null;
    }
    //添加商品
    public boolean add(Goodss goodss){
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();

        try{
            for (Goods tempGoogs : CommodityS) {
                //不能有相同的商品名字
                if (goodss.getName().equals(tempGoogs.getName())) {
                    return false;
                }
            }
        }catch (NullPointerException e){
            System.out.println("添加第一个商品"+goodss);
        }
        CommodityS.add(goodss);
       new Dao(CommodityS,1).write();
        return true;
    }

    //买东西一会,商品-1,购物车+1
    public Goods goShopp(String name) {
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();

        //空商品,判断,是否能购买成功
        Goods putGoods;
        for (int i = 0; i < CommodityS.size(); i++) {
            //找到商品
            if (name.equals(CommodityS.get(i).getName())) {
                //判断是否可以购买
                if (CommodityS.get(i).isState()) {
                    //判断数量 >0 才能买
                    if (CommodityS.get(i).getNumber() > 0) {
                        putGoods = CommodityS.get(i);
                        CommodityS.get(i).setNumber(CommodityS.get(i).getNumber() - 1);//数量-1
                        //写入,退出
                        new Dao(CommodityS,1).write();
                        return putGoods;
                    } else {
                        System.out.println("你来迟了,商品卖光了");
                    }
                } else {
                    System.out.println("商品不能购买!!!!");
                }
            }
        }
        return null;
    }
    public Goods goShoppFromEntertainmentManager(String name) {
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();

        //空商品,判断,是否能发放成功
        Goods putGoods;
        for (int i = 0; i < CommodityS.size(); i++) {
            //找到商品
            if (name.equals(CommodityS.get(i).getName())) {
                    //判断数量 >0 才能发奖品
                    if (CommodityS.get(i).getNumber() > 0) {
                        putGoods = CommodityS.get(i);
                        CommodityS.get(i).setNumber(CommodityS.get(i).getNumber() - 1);//数量-1
                        //写入,退出
                        new Dao(CommodityS,1).write();
                        return putGoods;
                    }
            }
        }
        return null;
    }

    public boolean remove(Goodss goodss) {
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();

        for (int i = 0; i < CommodityS.size(); i++) {
            if (goodss.getName().equals(CommodityS.get(i).getName())) {
                CommodityS.remove(i);
                new Dao(CommodityS,1).write();
                return true;
            }
        }

        return false;
    }

    public boolean remove(String goodssName) {
        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();
        for (int i = 0; i < CommodityS.size(); i++) {
            if (goodssName.equals(CommodityS.get(i).getName())) {
               Goodss goodss=CommodityS.get(i);
                remove(goodss);
                return true;
            }
        }
        new Dao(CommodityS,1).write();
        return false;
    }

    public boolean ChangeGoods(Goodss goodss){
//        ArrayList<Goodss> CommodityS = Commodity.getCommodityslist();
//        CommodityS= (ArrayList<Goodss>) new Dao(CommodityS,1).read();

//        Goodss tempGoodss=goodss;//缓存数据,
        String nam=goodss.getName();
        Scanner input= new Scanner(System.in);
        int m = 0;
        do {
            System.out.println("****************预览信息*********************");
            System.out.println(goodss);
            System.out.println("******************************************");
            System.out.println("1.修改商品名字");
            System.out.println("2.修改商品价格");
            System.out.println("3.修改商品状态");
            System.out.println("4.修改商品数量");
            System.out.println("5.完成商品修改");
            System.out.println("0.取消修改并返回");
            System.out.println("请选择:");
            m = input.nextInt();
            switch (m) {
                case 1:
                    System.out.println("输入新名称:");
                    goodss.setName(input.next());
                    break;
                case 2:
                    System.out.println("输入新价格:");
                    goodss.setPrice(input.nextFloat());
                    break;
                case 3:
                    System.out.println("输入新状态: (上架)y/(下架)n");
                    goodss.setState(input.next().charAt(0) == 'y' ? true : false);
                    break;
                case 4:
                    System.out.println("输入新数量:");
                    goodss.setNumber(input.nextInt());
                    break;
                case 5:
                    System.out.println(remove(nam));
                        add(goodss);
                    System.out.println("商品" + goodss.getName() + "修改成功");
                    m = 0;
                    break;
                default:
                    System.out.println("输入错误!!!");
            }


        } while (m!=0);
        return false;
    }
}
