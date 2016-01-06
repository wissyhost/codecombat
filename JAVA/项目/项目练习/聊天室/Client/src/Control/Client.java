package Control;

import Moble.Content;
import Moble.Tools;
import Moble.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Client {
    //命令
    public static final String update = "update";//更新数据
    public static final String exist = "exist?";//询问是否在线
    public static final String chat = "update";//聊天
    public static final String getFeiend = "getFeiend";
    public static final String login = "login";
    public static final String check = "check?";
    public static final String message1 = "message?";
    ServerSocket serverSocket=null;

    Socket client=null;

    public Map client2(Content content) throws UnknownHostException, IOException, ClassNotFoundException {
        //建立与指定服务器、端口的socket连接
        client= new Socket("localhost", 8088);
        //获得客户端的输出流，对应Server端的输入流
        OutputStream os = client.getOutputStream();
        ObjectOutputStream ps = new ObjectOutputStream(os);
        InputStream is = client.getInputStream();
        ObjectInputStream br = new ObjectInputStream(is);
        Map map = new HashMap();

        //往服务器端传输的数据
        if ("message?".equals(content.getCmd())) {
            ps.writeObject(content);
            ps.flush();
        }else if ("check?".equals(content.getCmd())) {
            ps.writeObject(content);
            ps.flush();
            Content con = (Content) br.readObject();
            int n = con.getNumber();
            while (n != 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                OutputStream oos = new FileOutputStream("D:\\Android\\IDEAPro\\codecombat\\项目\\项目练习\\聊天室\\Client\\src\\Moble\\" + ((n == 1) && (con.getValue1() == null) ? (String) con.getValue3() : (String) con.getValue1()));
                PrintStream printStream = new PrintStream(oos);
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    printStream.print(str);
                    printStream.println();
                }
                printStream.flush();
                printStream.close();
                bufferedReader.close();
                oos.close();
                System.out.println("接收完成");
                n--;
            }
        } else if ("login?".equals(content.getCmd())) {
            //客户端请求登陆
            ps.writeObject(content);
            ps.flush();
            Content content1 = (Content) br.readObject();
            map.put("login?", (Boolean) content1.getValue1());
            if ((Boolean) content1.getValue1()) {
                map.put("user", (User) content1.getValue2());
                Map<Integer,String>  myFriend=  (Map<Integer,String>)  content1.getValue3();
                Tools<Map<Integer,String>> tools= new Tools<Map<Integer,String>>();
                tools.writeMessage(myFriend,"myFriend.hashmap");
                Set<Integer> integers = myFriend.keySet();
                map.put("myFriend",myFriend);
//                clientSocetk();
            }
        } else if ("register?".equals(content.getCmd())) {
            ps.writeObject(content);
            ps.flush();
            Content con = (Content) br.readObject();
                map.put("register",(Boolean) con.getValue1() );
        } else if ("noLogin?".equals(content.getCmd())) {
            ps.writeObject(content);
            ps.flush();
        }
        //关闭流
        ps.close();
        os.close();
        br.close();
        is.close();
//        client.close();
        return map;
    }



    public  void clientSocetk(){
        try {
             serverSocket = new ServerSocket(9999);
             ReceiveMessage receiveMessage=new ReceiveMessage();
            receiveMessage.setReceiveMessage(serverSocket);
            receiveMessage.setName("聊天器后台线程");
            receiveMessage.setDaemon(true);
            receiveMessage.setPriority(4);
            receiveMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeClientServer(){
        if (serverSocket!=null){
            if (serverSocket.isClosed()){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
