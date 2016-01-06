package com.view;

import com.entity.User;
import com.service.Commodity_Management;
import com.service.EntertainmentManager;
import com.service.User_Management;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by wissy on 2015/11/19.
 */
public class StartShoping {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        User_Management user_management = new User_Management();
        ShopMenu menu = new ShopMenu();
        int m1;
        System.out.println("您好,欢迎使用购物管理系统!!");
        System.out.println("1.登陆\n2.注册\n0.退出");
        System.out.println("请选择:");
        m1 = input.nextInt();
        User user = new User(null, null, null);
      //登陆验证
        if (m1 == 1) {
            int acco = 1;//3次数如机会
            do {
                user = user_management.login();
                if (acco >= 3) {
                    System.out.println("没有输入次数了,系统退出");
                    System.exit(0);
                }
                acco++;
            } while (user == null);//输入正确就退出
        } else {
            user = user_management.regAccount();
        }
        //----------
        System.out.println("**********************************");
        System.out.println("********欢迎回来" +
                (!user.getJurisdiction().equals("admin") ? "普通用户" : "管理员**") + "!***********");
        System.out.println("***********************************\n\n" +
                "");
        //正式开始
        int m2 = 0;
        do {
            System.out.println("****************主菜单************");
            if (user.getJurisdiction().equals("admin")) {
                System.out.println("1.商品管理");
            } else {
                System.out.println("1.商品列表");
            }
            System.out.println("2.我的商品管理");
            System.out.println("3.信息管理");
            System.out.println("4.娱乐");
            System.out.println("5.我的商品");
            System.out.println("0.注销");
            System.out.println("**********************************");
            System.out.println("请选择:");
            m2 = input.nextInt();
            switch (m2) {
                case 1:
                    if (user.getJurisdiction().equals("admin")) {
                        menu.admin_m1(user);
                    } else {
                        menu.m1(user);
                    }
                    break;
                case 2:
                    menu.m2(user);
                    break;
                case 3:
                    menu.m3(user);
                    break;
                case 4:
                    menu.m4(user);
                    break;
                case 5:
                    user_management.MyShoplist(user);
                    break;
            }
        } while (m2 != 0);
        System.out.println("谢谢使用,退出");
    }
}
