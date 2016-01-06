package WEB.HollywoodChatRoom;

import java.io.*;
import java.net.*;
import java.sql.*;

/**
 * Created by wissy on 2015/12/4.
 */

class service extends Thread{
    private DatagramSocket socket=null;
    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }
//    private InetAddress ip;
    private int port;

//    public void setIp(InetAddress ip) {
//        this.ip = ip;
//    }

    public void setPort(int port) {
        this.port = port;
    }
    @Override
    public void run() {
        byte[] bytes=new byte[1024];
        DatagramPacket packet =new DatagramPacket(bytes,0,bytes.length);

        try {
            socket.receive(packet);
            service a=new service();
            a.setPort(port);
            a.setSocket(socket);
            Thread ser=new Thread(a,"飞秋服务器");
            ser.start();
            Connection conn = MysqlConntion.getConn();
            PreparedStatement ps = null;
            String sql="INSERT INTO test.charlog (fromHost, fromName, toHost, toName, date, contecnt) VALUES  (?, ?, ?, ?, ?,?)";
            try {
               ps=conn.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.setString(1,packet.getAddress().getHostAddress());
                ps.setString(2,packet.getAddress().getHostName());
                ps.setString(3,InetAddress.getLocalHost().getHostAddress());
                ps.setString(4,InetAddress.getLocalHost().getHostName());
                ps.setDate(5,new Date(System.currentTimeMillis()));
                String s = new   String(packet.getData());
                ps.setString(6,s );
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Send implements Runnable{
    String message=null;

    public void setMessage(String message) {
        this.message = message;
    }
    private InetAddress ip;
    private int port;

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        DatagramSocket socket= null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        byte[] bytes=message.getBytes();

        DatagramPacket packet =new DatagramPacket(bytes,0,bytes.length,ip,port);
        try {
            socket.send(packet);
            //数据处理
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
public class HollywoodChatRoom {
    public static void main(String[] args) throws SocketException, UnknownHostException {

        DatagramSocket socket=new DatagramSocket(8888);

        service service=new service();
        service.setPort(8888);
        service.setSocket(socket);
        service.setName("飞秋--1");
        service.start();

//
//        //主机存活包
        for (int i = 0; i < 253; i++) {
            Send send=new Send();
            send.setPort(8888);
            send.setMessage("exist?");
            send.setIp(InetAddress.getByName("192.168.1."+(1+i)));
            Thread thread=new Thread(send,"xx");
            thread.start();
        }
    }
}
