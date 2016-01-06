package Control;

import Moble.*;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wissy on 2015/12/8.
 */
public class Server extends Thread {
    int[] register=new int [0];
    private Socket socket = new Socket();

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static final String CountentPATH = "D:\\Android\\IDEAPro\\codecombat\\项目\\项目练习\\聊天室\\server\\src\\Moble\\Content.java";
    public static final String UserPATH = "D:\\Android\\IDEAPro\\codecombat\\项目\\项目练习\\聊天室\\server\\src\\Moble\\User.java";
    //Content content;
    //-----------

    //-----------

    @Override
    public void run() {
        System.out.println("新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
        InputStream inputStream = null;
        ObjectInputStream oi = null;
        OutputStream outputStream = null;
        ObjectOutput oo = null;
        DataInputStream dataInputStream = null;
        ResultSet resultSet = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        try {
            inputStream = socket.getInputStream();
            oi = new ObjectInputStream(inputStream);
            outputStream = socket.getOutputStream();
            oo = new ObjectOutputStream(outputStream);

            Content o = (Content) oi.readObject();//接受报

            //回应报
            Content con = new Content(null, null, null, null, null, socket.getInetAddress(), InetAddress.getLocalHost());
            if ("message?".equals(o.getCmd())) {
                System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "请求转发消息");

                User tempUser = new User();
                tempUser.setId((int) o.getValue2());//查看接受方iD
                //?
                ArrayList<User> temp = UserToDB.DBToUser(tempUser);//通过数据库查询ID对应的User信息
                //?
                tempUser = temp.get(0);//如果查询正确的话,只能返回一条记录,为了健壮性,以第一条数据为准
                //测试
                System.out.println(tempUser.getId());
                System.out.println(tempUser.getInetAddress());
                System.out.println(tempUser.getIp());
                System.out.println(tempUser.getName());
                System.out.println(tempUser.getPasswd());
                System.out.println(tempUser.getoMessage());
                System.out.println(tempUser.getPort());

                o.setSendAddress(InetAddress.getLocalHost());//数据重置地址和命令
                o.setServerAddress(tempUser.getInetAddress());
                o.setCmd("message");

                if (tempUser.isStatus()) {//查看用户状态
                    //用户如果在线则转发信息
                    System.out.println(tempUser.getIp());//获取转发ID的IP和端口
                    System.out.println(tempUser.getPort());

                    Socket socket1 = new Socket(tempUser.getIp(), tempUser.getPort());
                    OutputStream outputStream1 = socket1.getOutputStream();
                    ObjectOutputStream objectInputStream1 = new ObjectOutputStream(outputStream1);
//                    objectInputStream1.write();
                    objectInputStream1.writeObject(o);                                                                              ///
                } else {
//                    用户不在线就存到数据库,离线信息
//                    ArrayList<Content> arrayList = new ArrayList<Content>();
                    ArrayList<Content> arrayList =tempUser.getoMessage();
                    arrayList.add(o);
                    tempUser.setoMessage(arrayList);
                    System.out.println("数据"+tempUser.getoMessage().size());
                    UserToDB.UserUpdateDb(tempUser);
                    System.out.println("用户离线,存入离线消息");
                }

            } else if ("check?".equals(o.getCmd())) {
                System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "请求检查文件更新");
                String md5Checksum = Tools.getMD5Checksum(CountentPATH);
                String md5Checksum1 = Tools.getMD5Checksum(UserPATH);
                System.out.println("服务器检查Countent MD5:" + md5Checksum);
                System.out.println("服务器检查User MD5:" + md5Checksum1);

                int checknumber = 0;
                if (!md5Checksum.equals(o.getValue1())) {
                    checknumber++;
                    con.setCmd("update");
                    con.setValue1("Content.java");
                    con.setValue2(md5Checksum);
                }
                if (!md5Checksum1.equals(o.getValue2())) {
                    checknumber++;
                    con.setCmd("update");
                    con.setValue3("User.java");
                    con.setValue4(md5Checksum1);
                }
                con.setNumber(checknumber);
                oo.writeObject(con);
                oo.flush();
                while (checknumber != 0) {
                    InputStream is = new FileInputStream("D:\\Android\\IDEAPro\\codecombat\\项目\\项目练习\\聊天室\\server\\src\\Moble\\" + ((checknumber == 1) && (con.getValue1() == null) ? "User.java" : "Content.java"));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

                    PrintStream printStream = new PrintStream(outputStream);
//                DataInputStream dataInputStream = new DataInputStream(is);
//                byte[] bytes = new byte[1024];
                    String str;
                    while ((str = bufferedReader.readLine()) != null) {
                        printStream.print(str);
                        printStream.println();
                    }
                    printStream.flush();
                    printStream.close();
                    bufferedReader.close();
                    is.close();
                    checknumber--;
                }


                System.out.println("发送回应");


            } else if ("register?".equals(o.getCmd())) {
                synchronized (register) {
                    System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "请求注册用户");
                    User user = (User) o.getValue1();
                    con.setValue1(true);
                    String sql = "SELECT chat.char_user.user_name FROM chat.char_user WHERE user_name=?";
                    PreparedStatement connection = DBUtil.getConnection(sql);
                    connection.setString(1, user.getName());
                    ResultSet resultSet1 = connection.executeQuery();
                    while (resultSet1.next()) {
                        if (user.getName().equals(resultSet1.getString("user_name"))) {
                            //发送失败
                            con.setCmd("register");
                            con.setValue1(false);
                        }
                    }
                    if ((Boolean) con.getValue1()) {
                        User regtemp=new User(0,user.getName(),user.getPasswd(),false,"0.0.0.0"//减少网络传输流量
                                ,9999,socket.getInetAddress(),new ArrayList<Content>());
                        if (!UserToDB.UserToDB(regtemp)) {//数据库添加用户
                            con.setValue1(false);
                        }
                    }
                    System.out.println(user.getName() + ((Boolean) con.getValue1() ? "注册成功" : "注册失败"));
                    oo.writeObject(con);
                    oo.flush();
                }
            } else if ("exist?".equals(o.getCmd())) {
                System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "请求检查好友是否存在");
                oo.writeObject(new Content("exit", "wissy", "aaa", null, null, socket.getInetAddress(), InetAddress.getLocalHost()));
                oo.flush();
                System.out.println("发送回应");
            } else if ("exist".equals(o.getCmd())) {
                System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "存在请求回应");
                String sql = "INSERT INTO chat.chat_info ( chat_ip, char_name) VALUES (?,?)";
                PreparedStatement connection = DBUtil.getConnection(sql);
                connection.setString(1, socket.getInetAddress().getHostAddress());
                connection.setString(2, "aa");/////////
                connection.execute();
                DBUtil.close();
                System.out.println("信息以保存:");
            } else if ("login?".equals(o.getCmd())) {
                User user = (User) o.getValue1();
                System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "请求登陆");

                String sql = "SELECT * FROM chat.char_user WHERE user_name=? AND user_passwd=?;";
                PreparedStatement connection = DBUtil.getConnection(sql);
                connection.setString(1, user.getName());
                connection.setString(2, user.getPasswd());
                resultSet = connection.executeQuery();
                if (resultSet.isClosed()) {
                    System.out.println("关闭1");
                }
                Content content = new Content();
                content.setCmd("login");
                boolean a = false;
                // User user1 = new User();
                while (resultSet.next()) {
                    String name = resultSet.getString("user_name");
                    String passwd = resultSet.getString("user_passwd");
                    if (name != null) {
                        if (passwd != null) {
                            if ((user.getName().equals(name)) && ((user.getPasswd().equals(passwd)))) {
                                user.setId(resultSet.getInt("user_id"));
                                //user1.setName(resultSet.getString("user_name"));
//                                user1.setPasswd(resultSet.getString("user_passwd"));//不应该返回密码
                                System.out.println("设置用户" + user.getName() + "为上线状态");
                                UserToDB.alterUserFiled("user_status", "1", user.getId());
                                System.out.println("设置用户" + user.getName() + "上线IP");
                                UserToDB.alterUserFiled("user_ip", (String) socket.getInetAddress().getHostAddress(), user.getId());
                                a = true;//成功
                                break;
                            }
                        }
                    }
                }
                System.out.printf("用户" + user.getName() + (a ? "登陆成功" : "登陆失败"));
                content.setValue1(a);
                content.setValue2(user);
                content.setValue3(UserToDB.getUserFriend(user));
                oo.writeObject(content);
                oo.flush();
            } else if ("noLogin?".equals(o.getCmd())) {
                User user = (User) o.getValue1();
                System.out.println(df.format(new Date()) + " 客户端:" + socket.getInetAddress().getHostAddress() + "请求注销");
                System.out.println("设置用户名" + user.getName() + "为下线");
                UserToDB.alterUserFiled("user_status", "0", user.getId());
            } else {
//                System.out.println("zhunbei");
//                oo.writeObject(content);
//                oo.flush();
                System.out.println("已发送:");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                DBUtil.close();
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
                if (oi != null)
                    oi.close();
                if (oo != null)
                    oo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(8088);
//        ServerSocket serverSocket1 = new ServerSocket(8888);
//            Socket accept = serverSocket.accept();
        while (true) {
            Server server = new Server();
//        server.setSocket(serverSocket.accept());
            server.setSocket(serverSocket.accept());
            server.start();
//        server.join();
        }
//        serverSocket.close();
    }

}
