package com.service;

import com.entity.User;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by wissy on 2015/11/24.
 */
public class EntertainmentManager {
    /**
     * 娱乐活动管理
     */


    public void luckDraw(User user){
        //商品发放对象
        System.out.println("欢迎来到拼运气");
        System.out.println("中奖需知:头等奖:价值6588元(Mac超薄笔记本一台)总共1台" +
                "\n\t\t一等奖:价值4499元(联想小新v3笔记本一台)总共10台\n\t\t二等奖:价值949(华为荣耀畅玩4C一部)总共120台\n\t\t三等奖:" +
                "不锈钢做饭套餐一套(居家必备)总共100套");
        System.out.println("游戏说明:输入6个1-100的数字,每输入一个同时系统也会生成随机数字与您输入的数字进行取绝对值" +
                "\n\t\t计算6个绝对值之和,头等奖(0或者100),一等奖(1),二等奖(2),三等奖(3)");
        Scanner input= new Scanner(System.in);
        //6个数字
        int[] luckDrawNumberAyyay= new int[6];
        int[] randomAyyay= new int[6];
        int poor=0;
        for (int i=0;i<luckDrawNumberAyyay.length;i++) {//要小于用户的数组,不能是随机数的数组
            System.out.println("输入你的幸运数字"+(i+1)+"(1-100):");
           do {
                luckDrawNumberAyyay[i]=input.nextInt();
               if (!(luckDrawNumberAyyay[i]<100&&luckDrawNumberAyyay[i]>0)){
                   System.out.println("输入错误,请重新输入:");
               }
           }while(!(luckDrawNumberAyyay[i]<100&&luckDrawNumberAyyay[i]>0));
            //随机
            randomAyyay[i]=(int)((Math.random()*100)+1);
            poor=Math.abs(luckDrawNumberAyyay[i]-randomAyyay[i]);
        }

        System.out.println("`/\\︵/\\`  /\\_/\\ z");
        System.out.println("(=^∶^=) (=~.~=)");
        System.out.println("(~)︾(~) (~)@(~)﹏.ゅ)﹏-结果出来了看一下吧--");
        System.out.println("**********************************");
        System.out.print("\n你输入的是:  ");
        for (int t :luckDrawNumberAyyay) {
            System.out.print(t+"\t");
        }
        System.out.print("\n系统生成的是:");
        for (int t :randomAyyay) {
            System.out.print(t+"\t");
        }
        System.out.print("\n您与系统的差值是:"+poor);
       //计算奖品
        User_Management user_management=new User_Management();
        if (poor==100||poor==0){
            System.out.println("你人品弱爆了,获得头等奖");
           if ( user_management.addShopFromEntertainmentManager("Mac超薄笔记本",user)){
               System.out.println("得到Mac超薄笔记本一台");
            }else{
               System.out.println("你来迟了Mac超薄笔记本全部抽光了");
           }

        }else if (poor<1){
            System.out.println("您中了一等奖!!!");
            if ( user_management.addShopFromEntertainmentManager("联想小新v4笔记本",user)){
                System.out.println("得到联想小新v3笔记本一台");
            }else{
                System.out.println("你来迟了联想小新v3笔记本全部抽光了");
            }
        } else if (poor<2) {
            System.out.println("您中了二等奖!!");
            if ( user_management.addShopFromEntertainmentManager("华为荣耀畅玩4C",user)){
                System.out.println("华为荣耀畅玩4C一部");
            }else{
                System.out.println("你来迟了华为荣耀畅玩4C全部抽光了");
            }
        }else if (poor<3){
            System.out.println("您中了三等奖!");
            if ( user_management.addShopFromEntertainmentManager("不锈钢做饭套餐一套",user)){
                System.out.println("不锈钢做饭套餐一套");
            }else{
                System.out.println("你来迟了不锈钢做饭套餐一套全部抽光了");
            }
        }else{
            System.out.println("很遗憾,差值太大个,招财猫够不到啊!!");
        }
    }

}
