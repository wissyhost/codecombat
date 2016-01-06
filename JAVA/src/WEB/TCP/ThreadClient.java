package WEB.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by wissy on 2015/12/4.
 */

class Mythread1 extends Thread {
    private Socket client =null;

    public void setSocket(Socket client) {
        this.client = client;
    }

    String a = null;

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public void run() {
        InputStream ips = null;
        OutputStream ops = null;
        BufferedReader bf = null;
        PrintStream ps = null;
        try {
            ips = client.getInputStream();
            ops = client.getOutputStream();
            bf = new BufferedReader(new InputStreamReader(ips));
            ps = new PrintStream(ops);



            ps.println(a);
            ps.flush();

            String s = bf.readLine();

            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (ops != null)
                    ops.close();
                if (bf != null)
                    bf.close();
                if (ips != null)
                    ips.close();
//                if (client!=null)
//                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadClient {
    public static void main(String[] args) throws IOException {
//        Socket socket=new Socket("127.0.0.1",8888);
//
//        Mythread1 mythread1=new Mythread1();
//        mythread1.setSocket(socket);
//        mythread1.setA("ss");
//        mythread1.start();

        boolean b = true;
        try {

            while (b) {
                Socket socket = new Socket("127.0.0.1", 8888);
                System.out.println("输入发送内容:");
                String s = new Scanner(System.in).next();
                if ("exit".equals(s)) {
                    break;
                }
                Mythread1 mythread1 = new Mythread1();
                mythread1.setSocket(socket);
                mythread1.setA(s);
                mythread1.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
