package com.view;

import com.entity.Commodity;
import com.entity.Goods;
import com.entity.Goodss;
import com.entity.User;
import com.service.Commodity_Management;
import com.service.EntertainmentManager;
import com.service.User_Management;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wissy on 2015/11/20.
 */
public class ShopMenu {
    Commodity_Management commodityManagement = new Commodity_Management();
    Scanner input = new Scanner(System.in);
    User_Management user_management = new User_Management();

    //主菜单11111
    public void admin_m1(User user){
        int m1 = 0;
        do {
            System.out.println("主菜单-->商品管理-->");
            System.out.println("1.商品列表");
            System.out.println("2.添加商品");
            System.out.println("3.删除商品");
            System.out.println("4.修改商品");
            System.out.println("5.查询商品");
            System.out.println("0,返回主菜单");
            System.out.println("**********************************");
            System.out.print("请选择:");
            m1 = input.nextInt();
            switch (m1) {
                case 1:
                    admin_m11(user);
                    break;
                case 2:
                    admin_m12();
                    break;
                case 3:
                    admin_m13();
                    break;
                case 4:
                    admin_m14();
                    break;
                case 5:
                    admin_m15();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入错误!!!");
            }
        } while (m1 != 0);
    }

    private void admin_m11(User user) {
        System.out.println("主菜单-->商品管理-->商品列表-->");
        System.out.println("---------------商品---------");
        commodityManagement.list();
        System.out.println("********************************************************************");
        System.out.println("购买商品直接输入商品序号然后回车,否则输入0:");
        int m3;
        m3 = input.nextInt();
        if (m3 != 0) {//没有0这个编号
            commodityManagement.idSearch(m3);
            System.out.println("确认: 输入y确认?");
            char m4 = input.next().charAt(0);
            if (m4 == 'y') {
                Goodss jj=commodityManagement.idSearch(m3);
                user_management.addMycar(jj.getName(), user);
                System.out.println("购买成功!!");
            }
        }
    }

    private void admin_m12() {
        int m;
        do {
            System.out.println("主菜单-->商品管理-->添加商品-->");
            System.out.println("---------------添加商品---------");
            System.out.println("输入商品名称:");
            String name = input.next();
            System.out.println("输入商品数量:");
            int number = input.nextInt();
            System.out.println("输入商品价格:");
            float price = input.nextFloat();
            System.out.println("商品是否上架? y/n");
            boolean state = input.next().charAt(0) == 'y' ? true : false;
            Goodss goodss = new Goodss(name, price, number, state);
            commodityManagement.add(goodss);
            System.out.println("商品" + goodss.getName() + "添加成功");
            System.out.println("输入 0 返回商品管理");
            m=input.nextInt();
        }while (m!=0);

    }

    private void admin_m13(){
        int m;
        do {
        System.out.println("主菜单-->商品管理-->删除商品-->");
        System.out.println("---------------删除商品---------");
        System.out.println("输入商品名称:");
        String name = input.next();
        Goodss goodss = commodityManagement.nameSearch(name);
        if (goodss != null) {
            System.out.println("是否删除商品?" + goodss.getName() + " y/n");
            if (input.next().charAt(0) == 'y') {
                commodityManagement.remove(goodss);
                System.out.println("商品" + goodss.getName() + "删除成功");
            }
        } else {
            System.out.println("没有此商品,请核对后删除");
        }
            System.out.println("**********************************");
            System.out.println("输入 0 返回商品管理");
            m=input.nextInt();
        }while (m!=0);
    }
      public void admin_m14(){
        int m10;
          do{
        System.out.println("主菜单-->商品管理-->修改商品");
          System.out.println("****************改商品************");
          System.out.println("1.按名称修改商品");
          System.out.println("2.按id号修改商品");
          System.out.println("0.返回商品管理");
              System.out.println("****************************");
            System.out.print("请选择:");
            m10=input.nextInt();
              switch (m10){
                  case 1:
                      admin_m141();
                      break;
                  case 2:
                      admin_m142();
                      break;
                  case 0:
                      break;
                  default:
                      System.out.println("输入错误!!!");
              }
        }while (m10!=0);

    }

    private void admin_m141() {
        System.out.println("主菜单-->商品管理-->修改商品-->按名称修改商品");
        System.out.println("****************按名称修改商品************");
       int m11;
        do {
        System.out.println("输入商品名称:");
        String name = input.next();
        Goodss goodss = commodityManagement.nameSearch(name);
        if (goodss == null) {
            System.out.println("没有此商品,请核对后修改");
        } else {
            new Commodity_Management().ChangeGoods(goodss);
        }
            System.out.println("**********************************");
            System.out.println("输入0,返回商品管理");
            m11=input.nextInt();
        }while(m11!=0);
    }

    private void admin_m142(){
        int m10;
        do{
            System.out.println("主菜单-->商品管理-->修改商品");
            System.out.println("****************按id修改商品************");
             commodityManagement.list();
            System.out.println("请输入id:");
            int id= input.nextInt();
            Goodss goodss=commodityManagement.idSearch(id);
            if (goodss!=null){
                commodityManagement.ChangeGoods(goodss);
            }else{
                System.out.println("id错误");
            }

            System.out.println("0.返回商品管理");
            System.out.println("****************************");
            System.out.print("请选择:");
            m10=input.nextInt();
            switch (m10){
                case 1:
                    admin_m141();
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入错误!!!");
            }
        }while (m10!=0);
        //System.in.read();

    }

    private void admin_m15() {
        int m=0;
        System.out.println("主菜单-->商品管理-->查询商品-->");
        System.out.println("---------------查询商品---------");
        do{
        System.out.println("输入商品名称:");
        String name = input.next();
        Goodss goodss = commodityManagement.nameSearch(name);
        if (goodss != null) {
            System.out.println(goodss);
        } else {
            System.out.println("没有此商品,请核对后查询");
        }
            System.out.println("**********************************");
        System.out.println("输入 0 返回商品管理");
            m=input.nextInt();
    }while (m!=0);
    }

    //商品列表
    public void m1(User user) {
        int m=0;
        do{
        System.out.println("主菜单-->商品列表-->");
        System.out.println("************商品******************");
        commodityManagement.list();
        System.out.println("**********************************");
        System.out.println("购买商品直接输入商品序号然后回车,否则输入0:");
        int m3;
        m3 = input.nextInt();
        if (m3 != 0) {//没有0这个编号
            Goods tempGoods = commodityManagement.idSearch(m3);
            if (tempGoods != null) {
                System.out.println("确认: 输入y确认?");
                char m4 = input.next().charAt(0);
                if (m4 == 'y') {
                    user_management.addMycar(tempGoods.getName(), user);
                    System.out.println("添加购物车成功!!!");
                }
            } else {
                System.out.println("没有这个序号");
            }
        }
            System.out.println("**********************************");
            System.out.println("输入 0 返回商品列表");
            m=input.nextInt();
        }while (m!=0);
    }

    //主菜单22
    public void m2(User user) {
        int m=0;
        do{
        System.out.println("主菜单-->我的商品管理");
            System.out.println("1.查看我购物车");
            System.out.println("2.查看我的商品");
            System.out.println("0.返回主菜单");
        System.out.println("**********************************");
            switch (m){
                case 1:
                    m21(user);
                    break;
                case 2:
                    m22(user);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("输入有误");
            }
        System.out.println("输入 0 返回主菜单");
            m=input.nextInt();
    }while (m!=0);
    }
    public void m21(User user) {
        int m=0;
        do{
            System.out.println("主菜单-->我的商品管理-->我的购物车");
            System.out.println("***************我的购物车*****************");
            user_management.Mycarlist(user);
            System.out.println("**********************************");
            System.out.println("输入 0 返回主菜单");
            m=input.nextInt();
        }while (m!=0);
    }
    public void m22(User user) {
        int m=0;
        do{
            System.out.println("主菜单-->我的商品-->");
            ArrayList<Goods> a=user.getMyshop();
            for (int i=0;i<a.size();i++) {
                System.out.println(a.get(i));
            }
            System.out.println("**********************************");
            System.out.println("输入 0 返回主菜单");
            m=input.nextInt();
        }while (m!=0);
    }

    //主菜单3
    public void m3(User user) {
        //判断aa
//        if (user.getJurisdiction().equals("admin")) {
            int m3;
            do {
                System.out.println("主菜单-->信息管理---->");
                System.out.println("1.个人信息管理");
                if (user.getJurisdiction().equals("admin")){
                    System.out.println("2.全部客户信息管理");
                }
                System.out.println("0.返回主菜单");
                System.out.println("**********************************\n请选择:");
                m3 = input.nextInt();
                switch (m3) {
                    case 1:
                        m31(user);
                        break;
                    case 2:
                        if (user.getJurisdiction().equals("admin")){
                            m32(user);
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("输入错误!!!");
                }
            } while (m3 != 0);
//        }
    }


    //3级菜单1
    private void m31(User user) {
        char m5;
        do{
        System.out.println("主菜单-->信息管理-->个人信息管理-->");
        System.out.println(user);
        System.out.println("确认:是否要修改个人信息,输入y/n");
         m5 = input.next().charAt(0);//=='y'?'y':'0';
        if (m5 == 'y') {
            User tempUser=user_management.ChangUser(user,user);
            if (tempUser!=null){
                user=tempUser;
            }
        }
            System.out.println("输入 0 返回信息管路");
            m5 = input.next().charAt(0);
    }while (m5!='0');
    }

    //3的二级菜单
    private void m32(User user) {
        int m6 = 0;
        do {
            if (user.getJurisdiction().equals("admin")) {
                System.out.println("主菜单-->信息管理-->全部信息管理-->");
                System.out.println("1.显示全部信息");
                System.out.println("2.添加客户信息");
                System.out.println("3.修改客户信息");
                System.out.println("4.删除客户信息");
                System.out.println("0.返回信息管理");
                m6 = input.nextInt();
                switch (m6) {
                    case 1:
                        user_management.listUser();
                        break;
                    case 2:
                        int m7;
                        do {
                            System.out.println("输入客户的昵称");
                            String name = input.next();
                            if (user_management.searchUser(name) == null) {
                                System.out.println("输入密码:");
                                String passwd = input.next();
                                System.out.println("输入客户权限1.管理员 2.普通用户");
                                String j = (input.nextInt() == 1 ? "admin" : "putong");
                                User user1 = new User(name, passwd, j);
                                user_management.addUser(user1);
                                break;
                            } else {
                                System.out.println("已有" + name + "用户" + "不能继续添加");
                            }
                            System.out.println("输入0,返回全部信息管理");
                            m7=input.nextInt();
                        }while(m7!=0);
                        break;
                    case 3:
                        int m8;
                        do {
                            System.out.println("请输入客户的名称:");
                            String name1 = input.next();
                            User user1 = user_management.searchUser(name1);
                            if (user1 != null) {
//                                User user2 = new User(name1, null, "putong");
                                if (user_management.ChangUser(user1,user)==null){
                                    System.out.println("修改失败");
                                }else{
                                    System.out.println("修改成功");
                                }
                            } else {
                                System.out.println("没有此用户,请核对后修改");
                            }
                            System.out.println("**********************************");
                            System.out.println("输入0,返回全部信息管理");
                            m8 = input.nextInt();
                        }while (m8!=0);
                        break;
                    case 4:
                        int m9;
                        do {
                        System.out.println("请输入客户的名称:");
                        String name2 = input.next();
                        User user2 = user_management.searchUser(name2);
                        if (user2 != null) {
                            User user4 = new User(name2, null, null);
                            user_management.deleteUser(user4);

                        } else {
                            System.out.println("没有此用户,请核对后修改");
                        }
                            System.out.println("**********************************");
                            System.out.println("输入0,返回全部信息管理");
                            m9 = input.nextInt();
                        }while (m9!=0);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("输入错误!!!");
                }
            } else {
                System.out.println("1.查看我的详细信息");
                System.out.println("0.返回信息管理");
                System.out.println("*****************************");
                System.out.print("请选择:");
                System.out.println(user_management.searchUser(user.getName()));
                m6=input.nextInt();
            }
        } while (m6 != 0);

    }
    public void m4(User user){
        int m10;
        System.out.println("主菜单-->娱乐");
        do{
            System.out.println("1.拼运气");
            System.out.println("0.返回主菜单");
            System.out.println("**********************************");
            m10=input.nextInt();
            switch (m10){
                case 1:
                    m41(user);
                    break;
            }

        }while (m10!=0);

    }
    private void m41(User user){
        int m10;
        System.out.println("主菜单-->娱乐-->拼运气");
        do{
            new EntertainmentManager().luckDraw(user);
            System.out.println("**********************************");
            System.out.println("输入0,返回主菜单");
            m10=input.nextInt();
        }while (m10!=0);

    }
//    public void m41(User user){
//        int m10;
//        System.out.println("主菜单-->娱乐-->抽奖");
//        do{
//            new EntertainmentManager().luckDraw(user);
//            System.out.println("输入0,返回主菜单");
//            m10=input.nextInt();
//        }while (m10!=0);
//
//    }
}
