import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wissy on 2015/11/27.
 */
public class UserMgr {
    public  static  List<User> users=new ArrayList<User>();
    //注册用户
    public void regist(User u){
        users=readUser();
        boolean a=true;
        for (User tempUser:users) {
            if (tempUser.getName().equals(u.getName())){
                a=false;
            }
        }
        if (a){
            users.add(u);
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败,已有此用户,换个用户名吧");
        }
        writeUser();
    }
    //显示集合中的所有用户
    public void showAllUser(){
users=readUser();
        for (User tempUser:users) {
            System.out.println(tempUser);
        }
    }
    //读文件
    public List<User> readUser(){
        List<User> readUsers=new ArrayList<User>();
        InputStream ips=null;
        ObjectInputStream ois=null;
        try {
            ips=new FileInputStream("users.data");
            ois=new ObjectInputStream(ips);
            readUsers= (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            writeUser();
            System.out.println("初始化化文件");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
                try {
                    if (ips!=null)
                    ips.close();
                    if (ois!=null)
                        ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return readUsers;
    }
    //写文件
    public  void writeUser(){
        OutputStream ops=null;
        ObjectOutputStream oos=null;

        try {
            ops=new FileOutputStream("users.data");
            oos=new ObjectOutputStream(ops);
            oos.writeObject(users);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (oos!=null)
                oos.close();

                if (ops!=null)
                ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
