package WEB.UDP;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by wissy on 2015/12/4.
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        //Create one data Socket,open port 8888
       DatagramSocket socket=new DatagramSocket(8888);
        //create one buffer
        byte[] bytes=new byte[1024];
        //create a data packet bytes size big
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
        //receive client data packet
        socket.receive(packet);

        //data packet infomation
        InetAddress net=packet.getAddress();
        byte[] data=packet.getData();
        int port=packet.getPort();
        System.out.println(new String(data));
        System.out.println(net.getHostName());
        System.out.println(port);

        socket.close();


    }
}
