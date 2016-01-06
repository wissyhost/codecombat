package com.beicai.wissy.test;

import com.beicai.wissy.service.DVDBiz;
import java.text.ParseException;
import java.util.Scanner;


/**
 * Created by wissy on 2015/11/18.
 */


public class DVDTest {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DVDBiz biz = new DVDBiz();
        biz.show();
        int choose = 0;
        String name = null;
        boolean flag = false;
        int a[] = new int[30];
        String date = null;
        System.out.println("欢 迎 使 用 迷 你 DVD 管 理 器");
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("\t1.新增DVD");
            System.out.println("\t2.查看DVD");
            System.out.println("\t3.删除DVD");
            System.out.println("\t4.借出DVD");
            System.out.println("\t5.归还DVD");
            System.out.println("\t6.退出");
            System.out.println("---------------------------------------------------");
            System.out.print("请选择：");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("此处实现增加DVD");
                    System.out.println("************************************************");
                    System.out.print("请输入DVD名称：");
                    name = sc.next();
                    biz.add(name);
                    System.out.print("按0返回上一级：");
                    a[0] = sc.nextInt();
                    if (a[0] == 0) {
                        flag = true;
                    }
                    break;
                case 2:
                    System.out.println("---> 查看DVD");
                    biz.show1();
                    System.out.print("按0返回上一级。");
                    a[1] = sc.nextInt();
                    if (a[1] == 0) {
                        flag = true;
                    }
                    break;
                case 3:
                    System.out.println("---> 删除DVD");
                    System.out.print("请输入DVD名称：");
                    String newname = sc.next();
                    biz.delete(newname);
                    System.out.print("按0返回上一级。");
                    a[1] = sc.nextInt();
                    if (a[1] == 0) {
                        flag = true;
                    }
                    break;
                case 4:
                    System.out.println("---> 借出DVD");
                    System.out.print("请输入DVD名称：");
                    String name1 = sc.next();
                    System.out.print("请输入借出日期（年-月-日）:");
                    date = sc.next();
                    biz.jiechu(name1, date);
                    System.out.print("按0返回上一级。");
                    a[1] = sc.nextInt();
                    if (a[1] == 0) {
                        flag = true;
                    }
                    break;
                case 5:
                    System.out.println("---> 归还DVD");
                    System.out.print("请输入DVD名称：");
                    String name2 = sc.next();

                    biz.guihuan(name2, date);

                    System.out.print("按0返回上一级。");
                    a[1] = sc.nextInt();
                    if (a[1] == 0) {
                        flag = true;
                    }
                    break;
                case 6:
                    flag = false;
                    System.out.println("感谢您的使用！");
                    break;
            }
        } while (flag == true);
    }
}