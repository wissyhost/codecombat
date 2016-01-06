package WEB.UDP;

import java.io.IOException;
import java.net.*;

/**
 * Created by wissy on 2015/12/4.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //Shift + alt+l(Eclipse)定义局部变量

        InetAddress[] Inet=new InetAddress[255];
        byte[][] bytes1=new byte[255][4];
        for (int i = 0; i < bytes1.length; i++) {
            bytes1[i]=new byte[]{(byte) 192,(byte) 168,(byte) 1,(byte) (1+i)};
            Inet[i]=InetAddress.getByAddress(bytes1[i]);
        }




        //create a 127.0.0.1 InetAddress Object
        //InetAddress net=InetAddress.getByName("192.168.1.131");
        //create port
        int port =8888;
        //netAddress and port create a DatagramSocket(Client) object Don use
        DatagramSocket client=new DatagramSocket();
        byte[] bytes="我爱北京天安门!!!!".getBytes();
        //DatagramPacket packet= new DatagramPacket(bytes, bytes.length, net, port);

        for (InetAddress  aa:Inet) {
            DatagramPacket packet= new DatagramPacket(bytes, bytes.length, aa, port);
            client.send(packet);
        }


//        byte[] bytes1=new byte[1024];
//        DatagramPacket packet1=new DatagramPacket(bytes1,bytes1.length);
//        client.receive(packet1);
//
//        System.out.println(new String(packet1.getData()));

        client.close();

    }

}
