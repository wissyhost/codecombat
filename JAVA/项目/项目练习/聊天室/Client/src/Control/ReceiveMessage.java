package Control;

import Moble.Content;
import Moble.Tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by wissy on 2015/12/10.
 */
public class ReceiveMessage extends Thread {


    ServerSocket receiveMessage=null;
    SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
    public void setReceiveMessage(ServerSocket receiveMessage) {
        this.receiveMessage = receiveMessage;
    }
//    public ServerSocket getReceiveMessage() {
//        return receiveMessage;
//    }

    @Override
    public void run() {
        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            Socket accept = receiveMessage.accept();
            //多线程
            ReceiveMessage receiveMessage1=new ReceiveMessage();
            receiveMessage1.setReceiveMessage(receiveMessage);
            receiveMessage1.setDaemon(currentThread().isDaemon());
            receiveMessage1.setName(currentThread().getName());
            receiveMessage1.setPriority(currentThread().getPriority());
            receiveMessage1.start();
            //
            inputStream= accept.getInputStream();
            objectInputStream=new ObjectInputStream(inputStream);
            Object o = objectInputStream.readObject();
            Content content= (Content) o;

            if ("message".equals(content.getCmd())){

                Client client=new Client();
                //添加到消息集合
                Tools<ArrayList<Content>> tools=new Tools<ArrayList<Content>>();
                ArrayList<Content> message = tools.readMessage("message.content");
                Content tempcontent=new Content();
                tempcontent.setValue1(content.getValue1());
                tempcontent.setValue2(content.getValue3());
                tempcontent.setValue3((String)df.format(new Date()));
                tempcontent.setValue4((Boolean)false);
                message.add(tempcontent);
                //测试
                System.out.println((String) content.getValue3());
                tools.writeMessage(message,"message.content");

                Tools<Map<Integer,String>> tools1=new Tools();
                Map<Integer, String> integerStringMap = tools1.readMessage("myFriend.hashmap");
                String[] split = integerStringMap.get(content.getValue1()).split(":");
                System.out.println("新消息消息来自"+"["+split[0]+"]:"+content.getValue3());
            }else {
                System.out.println("错误");
            }
        } catch (IOException e) {
            System.out.println("客户端启用ServerSocket失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream!=null)
                inputStream.close();
                if (objectInputStream!=null)
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
