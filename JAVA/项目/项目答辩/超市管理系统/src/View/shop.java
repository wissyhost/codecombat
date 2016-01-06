package View;

import Model.User;

import java.util.Scanner;

/**
 * Created by wissy on 2015/12/15.
 */
public class shop {
    private static final int ADDUSER=1;
    private static final int LOGIN=2;
    private static final int DELUSER=3;
    private static final int ALTERPASSWD=3;
    private static final String OPTION="1....";
   // private static final int OPTION="1....";

    private static final String EXIT="3";
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.println("欢迎看来到超市管理系统");
        System.out.println("---------------------");
        System.out.println("regedit");
//        switch ()
        User user=new User();


        int a;
        if (user!=null) { do {

                System.out.println("菜单!!!!选择");
                a = input.nextInt();
                if ("1".equals(a))
                    System.out.println("用户管理");
                if ("2".equals(a))
                    System.out.println("2222");
                if ("3".equals(a))
                    System.out.println("3333");
                if ("4".equals(a))
                    System.out.println("4444");
                if ("5".equals(a))
                    System.out.println("5555");
                if ("6".equals(a))
                    System.out.println("66666");

        }while (!EXIT.equals(a));
        }
        System.out.println("已经登出,祝您好运");

    }
}
