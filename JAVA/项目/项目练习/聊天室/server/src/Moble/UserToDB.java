package Moble;

import java.io.*;
import java.net.InetAddress;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wissy on 2015/12/9.
 */
public class UserToDB {
    public static Map<Integer, String> getUserFriend(User user) {
        Map<Integer, String> userFriend = new HashMap<Integer, String>();

        String sql = "SELECT * FROM chat.user_feiend WHERE chat.user_feiend.user_id=? OR chat.user_feiend.friend_id=? ;";
        PreparedStatement connection = DBUtil.getConnection(sql);
        //打印日志文件
        System.out.println(user.getName() + " 进入查询好友");

        try {
            connection.setInt(1, user.getId());
            connection.setInt(2, user.getId());
            ResultSet resultSet = connection.executeQuery();
            //处理返回结果
            while (resultSet.next()) {
                //查看一条好友记录中是user_id还是friend_id是自己,则查询另一条
                int id2 = resultSet.getInt("user_id");
                int id1 = resultSet.getInt("friend_id");
                if (id1 == user.getId()) {
                    sql = "SELECT * FROM chat.char_user WHERE user_id=" + id2 + " ;";
                } else {
                    sql = "SELECT * FROM chat.char_user WHERE user_id=" + id1 + " ;";
                }
                connection = DBUtil.getConnection(sql);
                ResultSet resultSet1 = connection.executeQuery();

                while (resultSet1.next()) {
                    String temp = resultSet1.getString("user_name") + ":" + (resultSet1.getBoolean("user_status") ? "在线" : "离线");
                    userFriend.put(resultSet1.getInt("user_id"), temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取好友列表
        return userFriend;
    }

    public static void UserUpdateDb(User user) {
        String sql="UPDATE chat.char_user SET  user_omessage=? WHERE user_id="+user.getId()+";";
//        StringBuffer sqlt = new StringBuffer();
//        sqlt.append("UPDATE chat.char_user SET  user_omessage=");
//        ArrayList<User> arrayList = DBToUser(user);
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (user.getoMessage() != user.getoMessage()) {
//                sqlt.append("").append("load_file(").append(user.getId()).append(".content) ");
//            }
//        }
//        sqlt.append(" ").append("WHERE user_id=").append(user).append(";");
//        String sql = sqlt.toString();
        PreparedStatement connection = DBUtil.getConnection(sql);

        ObjectOutputStream objectOutputStream=null;
        InputStream inputStream=null;
        try {
         objectOutputStream=new ObjectOutputStream(new FileOutputStream(user.getIp()+".update"));
            objectOutputStream.writeObject(user.getoMessage());
            objectOutputStream.flush();
           inputStream=new FileInputStream(user.getIp()+".update");
            connection.setBinaryStream(1,inputStream);
            System.out.println("更新数据"+sql);
            int i = connection.executeUpdate();
            System.out.println("修改了"+i+"条数据");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    if (objectOutputStream!=null)
                    objectOutputStream.close();
                    if (inputStream!=null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    //往数据库添加用户
    public static boolean UserToDB(User user) {
        String sql="INSERT INTO chat.char_user" +
                "(user_name,user_passwd,  user_status, user_ip," +
                " user_port, user_InetAddress,user_omessage)" +
                "VALUES(?,?,?,?,?,?,?);";
//        String sql="INSERT INTO chat.char_user" +
//                "(user_name,user_passwd,user_omessage)" +
//                "VALUES(?,?,load_file(?));";
//        String sql = "INSERT INTO chat.char_user ( user_name,user_passwd) VALUES (?,?);";
        PreparedStatement connection = DBUtil.getConnection(sql);
        try {
                connection.setString(1, user.getName());
                connection.setString(2, user.getPasswd());
                connection.setBoolean(3, user.isStatus());
                connection.setString(4, user.getIp());
                connection.setInt(5, user.getPort());
            OutputStream outputStream=new FileOutputStream("1.obb");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user.getInetAddress());
            objectOutputStream.flush();
            objectOutputStream.close();
            outputStream.close();
            InputStream inputStream=new FileInputStream("1.obb");
//                connection.setBlob(6,inputStream);
                connection.setBlob(6,inputStream);
//                connection.setObject(8,user.getoMessage());
            OutputStream outputStream1=new FileOutputStream("2.obb");
            ObjectOutputStream objectOutputStream1=new ObjectOutputStream(outputStream1);
            objectOutputStream1.writeObject(user.getoMessage());
            objectOutputStream1.flush();
            objectOutputStream1.close();
            outputStream1.close();
            InputStream inputStream1=new FileInputStream("2.obb");
            connection.setBinaryStream(7,inputStream1);
            connection.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库添加用户" + user.getName() + "失败");
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        System.out.println("数据库添加用户" + user.getName() + "成功");
        return true;
    }

    //查询用户
    public static ArrayList<User> DBToUser(User user) {
        String sql = "SELECT * FROM chat.char_user WHERE user_id=" + user.getId() + ((user.getName() == null) ? ";" : " AND user_name=" + user.getName() + ";");
        PreparedStatement connection = DBUtil.getConnection(sql);

        ArrayList<User> arrayList = new ArrayList<User>();
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            System.out.println(sql);
            ResultSet resultSet = connection.executeQuery();
            while (resultSet.next()) {
                User retUser = new User();
                retUser.setId(resultSet.getInt("user_id"));
                retUser.setPasswd(resultSet.getString("user_passwd"));
                retUser.setName(resultSet.getString("user_name"));
                retUser.setStatus(resultSet.getBoolean("user_status"));
                retUser.setIp(resultSet.getString("user_ip"));
                retUser.setPort(resultSet.getInt("user_port"));
//                //写对象到文件
//                File file = new File(retUser.getId() + ".content");
//                fileOutputStream = new FileOutputStream(file);
//                objectOutputStream = new ObjectOutputStream(fileOutputStream);
//                objectOutputStream.writeObject(resultSet.getDate("user_omessage"));
//                objectOutputStream.flush();
//                fileInputStream = new FileInputStream(file);
//                objectInputStream = new ObjectInputStream(fileInputStream);
//                retUser.setoMessage((ArrayList<Content>) objectInputStream.readObject());
//                retUser.setoMessage((ArrayList<Content>) resultSet.getBlob("user_omessage"));
//                //重新连接流
//                file = new File(retUser.getId() + ".InetAddress");
//                fileOutputStream = new FileOutputStream(file);
//                objectOutputStream = new ObjectOutputStream(fileOutputStream);
//                objectOutputStream.writeObject(resultSet.getDate("user_InetAddress"));
//                objectOutputStream.flush();
//                fileInputStream = new FileInputStream(file);
//                objectInputStream = new ObjectInputStream(fileInputStream);
//                retUser.setInetAddress((InetAddress) objectInputStream.readObject());
                InputStream user_inetaddress = resultSet.getBinaryStream("user_Inetaddress");
                ObjectInputStream objectInputStream1=new ObjectInputStream(user_inetaddress);
                Object o = objectInputStream1.readObject();
//                retUser.setInetAddress((InetAddress) resultSet.getObject("user_Inetaddress"));
                retUser.setInetAddress((InetAddress)o);
                InputStream user_omessage = resultSet.getBinaryStream("user_omessage");
                ObjectInputStream objectInputStream2=new ObjectInputStream(user_omessage);
                Object o1 = objectInputStream2.readObject();
                retUser.setoMessage((ArrayList<Content>) o1);
                arrayList.add(retUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
            try {
                if (objectOutputStream != null)
                    objectOutputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() > 1) {
            System.out.println("警告!!!!数据库查询User超过1");
        }
        return arrayList;
    }

    //修改用户的信息
    public static void alterUserFiled(String s, String s1, int id, String... args) {
        StringBuffer sqlt = new StringBuffer();
        sqlt.append("UPDATE chat.char_user SET ").append(s).append("='").append(s1).append("'");
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0)
                sqlt.append(" ").append(args[i]).append("='");
            sqlt.append(args[i]).append("'");
        }
        sqlt.append(" ").append("WHERE user_id=").append(id).append(";");
        String sql = sqlt.toString();
        PreparedStatement connection = DBUtil.getConnection(sql);
        try {
            System.out.print("用户ID:" + id + "执行了" + sql);
            int i = connection.executeUpdate();
            System.out.println("修改了" + i + "条记录");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
