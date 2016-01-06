package com.beicai.wissy.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import com.beicai.wissy.entity.DVD;

/**
 * Created by wissy on 2015/11/18.
 */


public class DVDBiz {
    DVD dvd[] = new DVD[30];
    Scanner sc = new Scanner(System.in);

    public void show() {
        dvd[0] = new DVD("罗马假日", 0, "2013-7-1");
        dvd[1] = new DVD("风声鹤唳", 1, "");
        dvd[2] = new DVD("浪漫满屋", 1, "");

    }

    public void show1() {
        System.out.println("序号\t状态\t名称\t借出日期");
        for (int i = 0; i < dvd.length; i++) {
            if (dvd[i] != null && dvd[i].getStates() == 0) {
                System.out.println((i + 1) + "\t已经借出" + "\t《" + dvd[i].getName() + "》\t" + dvd[i].getDate());
            } else if (dvd[i] != null && dvd[i].getStates() == 1) {
                System.out.println((i + 1) + "\t可借" + "\t《" + dvd[i].getName() + "》\t");
            }
        }
    }

    public void add(String name) {
        for (int i = 0; i < dvd.length; i++) {
            if (dvd[i] == null) {
                dvd[i] = new DVD(name, 1, "");
                System.out.println("添加《" + name + "》成功！");
                break;
            }
        }
    }

    public void delete(String name) {
        for (int i = 0; i < dvd.length; i++) {
            if (dvd[i] != null)
                if (dvd[i].getName().equals(name) && dvd[i].getStates() != 0) {
                    dvd[i] = null;
                    System.out.println("删除《" + name + "》成功！");
                    for (int j = i; j < dvd.length - 1; i++) {
                        dvd[j] = dvd[j - 1];
                    }
                    break;
                }
        }
    }

    public void jiechu(String name, String date) {
        for (int i = 0; i < dvd.length; i++) {
            if (dvd[i].getName() == null) {
                System.out.println("没有此书！");
                break;
            } else if (dvd[i].getName().equals(name) && dvd[i].getStates() == 0) {
                System.out.println("已经被借");
                break;
            } else if (dvd[i].getName().equals(name) && dvd[i].getStates() != 0) {
                dvd[i] = new DVD(name, 0, date);
                System.out.println("借出《" + name + "》成功");
                break;
            }
        }
    }

    public void guihuan(String name, String date2) throws ParseException {
        for (int i = 0; i < dvd.length; i++) {
            if (dvd[i].getName() == null) {
                System.out.println("没有此书！");
                break;
            } else if (dvd[i].getName().equals(name) && dvd[i].getStates() != 0) {
                System.out.println("未被借出");
                break;
            } else if (dvd[i].getName().equals(name) && dvd[i].getStates() == 0) {
                System.out.println("请输入归还日期");
                String date1 = sc.next();
                dvd[i] = new DVD(name, 1, date1);
                System.out.print("借出日期为：" + date2);
                System.out.println("归还日期为" + date1);
                System.out.println("归还《" + name + "》成功");
                SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
                Date one = DATE.parse(date1);
                Date two = DATE.parse(date2);
                GregorianCalendar gc = new GregorianCalendar();
                java.util.Calendar calstart = java.util.Calendar.getInstance();
                long u = 0;
                gc.setTime(one);
                gc.setTime(two);

                break;
            }
        }
    }

}
