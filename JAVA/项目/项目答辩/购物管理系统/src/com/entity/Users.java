package com.entity;

import java.util.*;

/**
 * Created by wissy on 2015/11/19.
 */
public class Users {
    //单例
    private static Map<String,User> Userlist= new HashMap<String, User>();
    private Users() {
    }
    public static Map<String,User> getUserlist(){
        return Userlist;
    }
    public static void setUserlist( Map<String,User> userlist){
        Userlist=userlist;
    }
}
