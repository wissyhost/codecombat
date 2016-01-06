package WEB.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by wissy on 2015/12/4.
 */
class MyServerThread extends Thread {
    private DatagramSocket server=null;

    public void setServer(DatagramSocket server) {
        this.server = server;
    }

    @Override
    public void run() {
        byte[] bytes=new byte[1024];
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
        try {
            server.receive(packet);
            MyServerThread myServerThread=new MyServerThread();
            myServerThread.setServer(server);
            myServerThread.start();

            System.out.println(new String(packet.getData()));
            byte[] bytes1=packet.getData();
            DatagramPacket packet1=new DatagramPacket(bytes1,bytes1.length,packet.getAddress(),packet.getPort());
            server.send(packet1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadServier {
    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket(1234);
        boolean b=false;
//        do {
            MyServerThread myServerThread=new MyServerThread();
            myServerThread.setServer(socket);
            myServerThread.start();
            System.out.println("lll");
        if (b)
            socket.close();

//        }while (b);

    }
}

