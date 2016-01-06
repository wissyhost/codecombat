package com.service;

import com.entity.Goods;
import com.entity.User;
import com.entity.Users;

import java.util.*;

/**
 * Created by wissy on 2015/11/19.
 */
public class User_Management {
    //账户管理器
    //获取底层对象地址
//    private Map<String,User> userList=Users.getUserlist();
//
//    //数据读取存储对象
//   Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);

    //构造器
    public User_Management() {
        initial();
    }

    public void initial(){
        Map<String,User> userList=Users.getUserlist();

        //数据读取存储对象
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
//读
        userList=dao.read();
        //会员为空
        if (userList.isEmpty()){
            System.out.println("读取用户数据,将添加默认系统管理员,名称:admin 密码:admin");
            userList.put("admin", new User("admin", 45, true, "admin", "admin"));
            //写入
            dao.write();
        }
    }
    /**
     * 背景,,功能.技术路线.管理路线
     */


    /**
     *  用户的增删改查
      */


    //浏览用户列表
    public void listUser(){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();
        Set<String> Name= userList.keySet();
        Iterator it=Name.iterator();
        System.out.println("*************全部客户信息*************");
        while (it.hasNext()){
            String s=(String) it.next();
            System.out.println( userList.get(s));
        }
    }
//增加用户
    public void addUser(User user){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();

        userList.put(user.getName(),user);
        //写入本地数据
        dao.write();
    }
    /**
     *  管理员:删除用户
     *  @param user 要删除的用户
     */

    public boolean deleteUser(User user){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();


       Set<String> Name= userList.keySet();
        Iterator it=Name.iterator();
        while (it.hasNext()){
           String s=(String) it.next();
            if (s.equals(user.getName())){
                userList.remove(s);
                if (dao.write()){
                    return true;
                }else {
                    return false;
                }
            }
        }
       return false;
    }

    //重载上面的方法
    //在这个方法中你客人输入指定人的姓名等等信息
    public User ChangUser(User changUser,User changUserByUser){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        //changUserByUser是谁修改的
        //changUser要修改的是谁
        userList=dao.read();
        Scanner input= new Scanner(System.in);
        User tempUser=changUser;
        deleteUser(changUser);
        int k;
        do {
            System.out.println("**********************************");
            System.out.println(changUser);
            System.out.println("**********************************");
            System.out.println("1.修改昵称");
            System.out.println("2.修改年龄");
            System.out.println("3.修改性别");
            System.out.println("4.修改密码");
            System.out.print((changUserByUser.getJurisdiction().equals("admin")?"5.修改账号的权限\n" : ""));
            System.out.println("0.返回");
            System.out.println("请选择:");
            k = input.nextInt();
            switch (k) {
                case 1:
                    System.out.println("输入新昵称");
                    changUser.setName(input.next());
                    break;
                case 2:
                    System.out.println("输入年龄");
                    changUser.setAge(input.nextInt());
                    break;
                case 3:
                    System.out.println("是否修改性别?  y");
                    if(input.next().charAt(0)=='y'){
                        changUser.setSex((changUser.isSex()?false:true));
                    }
                    break;
                case 4:
                    System.out.println("输入新密码");
                    changUser.setPasswd(input.next());
                    break;
                case 5:
                    if (changUserByUser.getJurisdiction().equals("admin")){
                        System.out.println("输入新权限:");
                        changUser.setJurisdiction(input.next());
                    }
                    break;
            }
        }while (k!=0);
        addUser(changUser);
     return  changUser;
    }
    /**
     *   查询用户
     */
    /**
     *
     * @param userName 要搜索的用户的名字
     * @return 有则返回一个用户实体,无则为null
     */
    public User searchUser(String userName){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();

        Set<String> Name= userList.keySet();

        Iterator it=Name.iterator();
        while (it.hasNext()){
            String s=(String) it.next();
            if(s.equals(userName))
            return  userList.get(s);
        }
        return null;
    }
    /**
     *账户登陆管理1,给出用户名和密码.
     * @param userName 查询指定用户名
     * @param passwd 查询UserName的密码
     * @return  User为一个实体用户
     */
    // 遍历集合查看有没有,有则返回对象,没有返回空
       public User account(String userName,String passwd){
           Map<String,User> userList=Users.getUserlist();
           Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
           userList=dao.read();
        //集合
        Set<String> userNames=userList.keySet();
        Iterator it=userNames.iterator();
        while (it.hasNext()){
            //判断集合有没有输入的名字
            if (userName.equals(it.next())){
                User temp=userList.get(userName);
                //密码和用户名对则返回用户
                if (passwd.equals(temp.getPasswd())){
                    return temp;//普通用户
                }
            }
        }
        return null;//没有用户名
    }
    //登陆
    public User login(){
        Scanner input= new Scanner(System.in);
        System.out.println("***************登陆***************");
        System.out.println("请输入你的用户名:");
        String userName=input.next();
        System.out.println("请输入你的密码:");
        String passwd=input.next();
        //进入账号管理器进行验证
        User user=account(userName,passwd);
        //不正确的
        if (user==null){
            System.out.println("警告:密码或用户名不正确,请重新输入");
        }
        return user;
    }
    //注册
    public User regAccount(){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();
        Scanner input= new Scanner(System.in);
        System.out.println("----------账号注册---------");
        System.out.println("请输入你要注册的用户名:");
        String userName=input.next();
        if (searchUser(userName)==null){
            System.out.println("输入你的性别: 男输入1 ,女输入 2");
            boolean sex=(input.nextInt()==1)?true:false;
            System.out.println("输入你的年龄:");
            int age= input.nextInt();
            String passwd1;
            String passwd2;
            do {
                System.out.println("请输入你的密码:");
                passwd1=input.next();
                System.out.println("请再次输入你的密码:");
                passwd2=input.next();
            }while(!passwd1.equals(passwd2));
            User user= new User(userName,age,sex,passwd1,"普通用户");
            new User_Management().addUser(user);
            System.out.println("用户名:"+user.getName());
            System.out.println("密码:"+user.getPasswd());
            System.out.println("请牢记此用户名和密码,这是你的以后的登陆凭证");
            System.out.println("\"恭喜你!成功完成注册.\"");
            dao.write();
            return user;
        }else{
            System.out.println("不能使用此用户名,已经被注册了");
        }
        return null;
    }
    /**
     *用户的购物车服务
     * @param CommodityName 商品名字
     *@param user 用户即实体
     *@return 真(成功)假(失败)
     */
    //将商品添加到购物车
    public boolean addMycar(String CommodityName,User user){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();


        Goods temp=new Commodity_Management().goShopp(CommodityName);//尝试购买商品
        //返回null则购买没有成功

        if(temp!=null){

            User u=userList.get(user.getName());

            userList.remove(user.getName());

            ArrayList<Goods> a=u.getMyshopCralist();
            for (int i = 0; i < a.size(); i++) {
                if (temp.getName().equals(a.get(i).getName())){
                    //////temp.setPrice();
                }
            }
            a.add(temp);

            u.setMyshopCralist(a);
            userList.put(u.getName(),u);

//
//            System.out.println("jjjjjj");
//            User tempUser= searchUser(user.getName());
//            deleteUser(user);
//
//
//            ArrayList<Goods> aa=tempUser.getMyshopCralist();
//            aa.add(temp);
//            tempUser.setMyshopCralist(a);


//            addUser(tempUser);
           dao.write();
            return true;
        }
        return false;
    }
    //将商品直接购买
    public boolean addShopFromShops(String CommodityName,User user){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();

        Goods temp=new Commodity_Management().goShopp(CommodityName);//尝试购买商品
        //返回null则购买没有成功
        System.out.println(temp);
        if(temp!=null){
            user.getMyshop().add(temp);
            //不为空,加到我的商品里
           dao.write();
            return true;
        }
        return false;
    }
    public boolean addShopFromEntertainmentManager(String CommodityName,User user){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();

        Goods temp=new Commodity_Management().goShoppFromEntertainmentManager(CommodityName);//尝试购买商品
        //返回null则购买没有成功
        System.out.println(temp);
        if(temp!=null){
            user.getMyshop().add(temp);
            //不为空,加到我的商品里
            dao.write();
            return true;
        }
        return false;
    }
    //参看购物车东西
    public void Mycarlist(User user){

        User tempUser=searchUser(user.getName());

      //  System.out.println(tempUser.getMyshopCralist());

        ArrayList<Goods> myCarList=tempUser.getMyshopCralist();
        for (int i=0;i<myCarList.size();i++){
            System.out.println("id:"+(i+1)+myCarList.get(i));
        }
    }
    //将从购物车购买
    public boolean addShoFromMycar(String CommodityName,User user){
        Map<String,User> userList=Users.getUserlist();
        Dao<Map<String,User>> dao = new Dao<Map<String, User>>(userList,2);
        userList=dao.read();
        User tempUser=searchUser(user.getName());
        ArrayList<Goods> myshopList=tempUser.getMyshop();
        for (int i=0;i<myshopList.size();i++){
            if (myshopList.get(i).getName().equals(CommodityName)){
                System.out.println(myshopList.get(i));
                System.out.println("应支付"+myshopList.get(i).getPrice());
                System.out.println("请输入支付金额:"+new Scanner(System.in).nextInt());
                dao.write();
                return true;
            }
        }
        return false;
    }

    //参看我的商品
    public void MyShoplist(User user){
        ArrayList<Goods> myshopList=searchUser(user.getName()).getMyshop();

        if (myshopList.size()!=0){
            for (int i=0;i<myshopList.size();i++){
                System.out.println("id:"+(i+1)+myshopList.get(i));
            }
        }else{
            System.out.println("没有东西哦!!");
        }

    }
}
