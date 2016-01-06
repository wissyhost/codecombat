import java.util.Scanner;

/**
 * Created by wissy on 2015/11/27.
 */
public class TestUser {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        UserMgr userMgr= new UserMgr();
        //加载文件里的数据
        userMgr.readUser();
        int m;
        do {
            System.out.println("1.注册用户");
            System.out.println("2.查看所有用户");
            System.out.println("0.退出");
            System.out.println("********************************");
            System.out.println("请输入:");
            m=input.nextInt();
            switch (m){
                case 0:
                    break;
                case 1:
                    System.out.println("请输入用户名:");
                    String name=input.next();
                    System.out.println("请输入密码:");
                    String passwd=input.next();
                    User user= new User(name,passwd);
                    userMgr.regist(user);
                    break;
                case 2:
                    userMgr.showAllUser();
                    break;
                default:
                    System.out.println("输入错误!!!请重新输入");
            }
        }while (m!=0);
    }
}
