package com.service;

import com.entity.User;

import java.io.*;

/**
 * Created by wissy on 2015/11/20.
 */
public class Dao <E> {
    /**
     * 类到文件的输入输出管理
     * E 泛型,你要存的是什么类型,取的是什么类型
     * i 用于标记是哪一个文件
     */
    String CommodityPATH="Commodity.dat";
    String UserPATH="User.dat";
    E object;
    int i;
    public Dao(E object,int i){
        this.object=object;
        this.i=i;
    }
    // 1  商品
    // 2  用户
    public E read(){
        File file=null;
        if (i==1){
            file = new File(CommodityPATH);
        }else if (i==2){
            file = new File(UserPATH);
        }
        InputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
    try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            //读入
            object = (E) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            write();
            System.out.println("初始化本地文件");
        } catch (IOException e) {
            System.out.println("不能写入该文件文件,请检查权限设置");
        } catch (ClassNotFoundException e) {
            System.out.println("文件转换为内部缓存异常了");
        }finally {
        //关流
        try {
           if (objectInputStream!=null){
               objectInputStream.close();
           }
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        } catch (IOException e) {
            System.out.println("数据流关闭失败或者文件正在初始化");
        }
    }
        return object;
    }

    //写数据
    public boolean write() {
        File file=null;
        if (i==1){
            file = new File(CommodityPATH);
        }else if (i==2){
            file = new File(UserPATH);
        }
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(file);
          objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //写入
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("不能写入该文件文件,请检查权限设置");
        }finally {
            try {
                //刷新,关流
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("数据流关闭失败");
            }
        }
        return  true;
    }
}
