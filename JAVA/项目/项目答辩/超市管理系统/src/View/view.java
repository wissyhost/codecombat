package View;

import Model.Commodity;
import Model.User;

import java.util.Scanner;

/**
 * Created by wissy on 2015/12/15.
 */
public class view {
    public User start() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------");
        int a;
        User login=null;
        do {
            System.out.println("1注册\n2登录\n3退出");
            a = input.nextInt();
            switch (a) {
                case 1:
                    regedit();
                    break;
                case 2:
                    login = login();
                    break;
                default:
                    System.out.println("选择有误,请重新选择");
            }
        } while (a != 3);
        return login;
    }
    public void menu1(User user){
        Scanner input=new Scanner(System.in);
        int a;
        System.out.println("商品信息管理");
        do {
            System.out.println("1添加商品\n2.修改商品\n3.删除商品\n4.查看商品\n" +
                    "0.返回上一级");
            a=input.nextInt();
            switch (a){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while (a!=0);

    }

    public void regedit() {
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.println("输入用户名");
        user.setUser_name(input.next());
        System.out.println("输入密码");
        user.setUser_passwd(input.next());
    }

    public User login() {
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.println("输入用户名");
        user.setUser_name(input.next());
        System.out.println("输入密码");
        user.setUser_passwd(input.next());
        // user=null;//去数据库判断
        return user;
    }
    public Boolean addShop(){
        //调用搜索商品,看是否有
        //没有则能添加
        return false;
    }
    public void shouShop(){
        //从数据库查看商品信息
    }
    public boolean delShop(){
        //搜索商品,有则确认后删除
        return false;
    }
    public Commodity searchShop(){
        //通过名字
        return null;
    }
    public boolean addWarehouse(){
         //查看数据库有同名厂库没有
        return false;
    }
    public boolean addSupplier(){
         //查看有无此供货商
        return false;
    }
    public boolean delSupplier(){
        //查看有无此供货商
        return false;
    }
    public boolean alterSupplier(){
        //查看有无此供货商
        return false;
    }
    public boolean shouSupplier(){
        //查看有无此供货商
        return false;
    }
    public boolean searchSupplier(){
        //查看有无此供货商
        return false;
    }



}
