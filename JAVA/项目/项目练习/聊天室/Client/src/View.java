

import Control.Client;
import Moble.Content;
import Moble.User;
import Moble.Tools;

import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

/**
 * Created by wissy on 2015/12/8.
 */
public class View {

    public static final String CountentPATH = "D:\\Android\\IDEAPro\\codecombat\\项目\\项目练习\\聊天室\\Client\\src\\Moble\\Content.java";
    public static final String UserPATH = "D:\\Android\\IDEAPro\\codecombat\\项目\\项目练习\\聊天室\\Client\\src\\Moble\\User.java";
    public static final String option = "1.注册\n2.登陆\n3.退出";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        /*
        检查模板文件服务器是否有更新
         */
        Client client = new Client();
        Content content =new Content();
        try {
            String md5Checksum = Tools.getMD5Checksum(CountentPATH);
            String md5Checksum1 = Tools.getMD5Checksum(UserPATH);
//            System.out.println("客户端Countent MD5值:" + md5Checksum);
//            System.out.println("客户端User MD5值:" + md5Checksum1);
            content=new Content("check?", md5Checksum, md5Checksum1, null, null, InetAddress.getLocalHost(), InetAddress.getLocalHost());
            client.client2(content);
            content=new Content(null, null, null, null, null, InetAddress.getLocalHost(), InetAddress.getLocalHost());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        功能开始界面
         */

        int a;
//        client.clientSocetk();
        do {
            System.out.println(option);
            a = input.nextInt();
            switch (a) {
                case 1:
                    User user1 = new User();
                    System.out.println("请输入注册用户名");
                    user1.setName(input.next());
                    String passwd1;
                    String passwd2;
                    do {
                        System.out.println("请输入注册密码");
                        passwd1 = input.next();
                        System.out.println("请重新输入密码");
                        passwd2 = input.next();
                        if (!passwd1.equals(passwd2)) {
                            System.out.println("两次密码输入不一样,请重新输入");
                        }
                    } while (!passwd1.equals(passwd2));

                    user1.setPasswd(passwd1);
                    Map map1 = client.client2(new Content("register?", user1, null, null, null, InetAddress.getLocalHost(), InetAddress.getLocalHost()));
                    System.out.println((Boolean) map1.get("register") ? "恭喜!注册成功,请牢记此用户名和密码" : "注册失败,已有此用户名换个试试吧");
                    break;
                case 2:
                    User user = new User();
                    System.out.println("请输入登录用户名");
                    user.setName(input.next());
                    System.out.println("请输入登录密码");
                    user.setPasswd(input.next());

                    content = new Content("login?", user, null, null, null, InetAddress.getLocalHost(), InetAddress.getLocalHost());

                    Map map = client.client2(content);
                    boolean ret = (boolean) map.get("login?");

                    if (ret) {
                        System.out.println("恭喜你,成功登陆");
                        client.clientSocetk();
                       // User userTemp = (User) map.get("user");
                         user = (User) map.get("user");
                        Map<Integer, String> myFriend = (Map<Integer, String>) map.get("myFriend");

                        //System.out.println(userTemp.getId() + userTemp.getName() + userTemp.getPasswd());
                        System.out.println("1.添加好友\n2.删除好友\n3.查看好友\n4.与好友聊天\n5.注销登陆");
                        int x22;
                        do {
                             x22 = input.nextInt();
                            switch (x22) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    //获取好友列表

                                    Set<Integer> strings = myFriend.keySet();
                                    Iterator<Integer> iterator = strings.iterator();
                                    System.out.println(myFriend.size()==0?("好友列表空空的,啥也没有"):("好友列表\n=============="));
                                    while (iterator.hasNext()) {
                                        String s = myFriend.get(iterator.next());
                                        String[] split = s.split(":");
                                        System.out.println("["+split[1]+"]"+"昵称:"+split[0]);
                                    }
                                    System.out.println("==============");
                                    break;
                                case 4:
                                    System.out.println("输入好友名,与好友聊天");
                                    String feiendName = input.next();
                                    Set<Integer> strings1 = myFriend.keySet();
                                    Iterator<Integer> iterator1 = strings1.iterator();
                                    boolean isFriend = false;
                                    int Id=0;
                                    String name=null;
                                    while (iterator1.hasNext()) {
                                        Id=iterator1.next();
                                        name=myFriend.get(Id);
                                        String[] split = name.split(":");
                                        if (split[0].equals(feiendName)) {
                                            isFriend = true;
                                            if (!"在线".equals(split[1]))
                                                System.out.println("对方不在线,只能发送离线消息");
                                            break;
                                        }
                                    }
                                    if (isFriend) {
                                        String messageToFriend;
                                        content.setCmd("message?");//配置头
                                        content.setValue1(user.getId());//发送方ID
                                        content.setValue2(Id);//接受方ID
                                       Tools<ArrayList<Content>> tools=new Tools<ArrayList<Content>>();
                                        do {
                                            ArrayList<Content> arrayList = tools.readMessage("message.content");
                                            Content content1;
                                            for (int i = 0; i <arrayList.size(); i++) {
                                                content1 = arrayList.get(i);
                                                System.out.println(myFriend.get(content1.getValue1())+":"+(String) content1.getValue3()+" "+content1.getValue2());
                                            }
                                            System.out.println("输入聊天消息 exit退出聊天");
                                            messageToFriend = input.next();
                                            if (!"exit".equals(messageToFriend)) {
                                                content.setValue3(messageToFriend);
                                                client.client2(content);
                                            }
                                        } while (!"exit".equals(messageToFriend));
                                    } else {
                                        System.out.println("好友名输入错误,没有那个好友");
                                    }
                                    break;
                                case 5:
                                    ///
                                    //发送离线
                                    //关闭接受消息服务器
                                    //content.setValue1(user);

                                    user.setPasswd("1");
                                    content = new Content("noLogin?", user, null, null, null, InetAddress.getLocalHost(), InetAddress.getLocalHost());

                                    client.client2(content);
                                    System.out.println("注销成功");
                                    break;
                                default:
                                    System.out.println("选择错误!!请重新选择");
                                    break;
                            }
                        } while (x22 != 5);
                        client.closeClientServer();
                    } else {
                        System.out.println("登陆失败");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
            }
        } while (a != 3);
        client.closeClientServer();
    }

}
