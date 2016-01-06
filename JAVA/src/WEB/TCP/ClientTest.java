package WEB.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

    public static void main(String[] args) throws IOException, IOException {
        client2();
    }
    private static void client2() throws UnknownHostException, IOException {
        //建立与指定服务器、端口的socket连接
        Socket client=new Socket("localhost",8888);
        //获得客户端的输出流，对应Server端的输入流
        OutputStream os=client.getOutputStream();
        PrintStream ps=new PrintStream(os);
        InputStream is=client.getInputStream();
        BufferedReader br=new BufferedReader(
                new InputStreamReader(is));
        //往服务器端传输的数据
        //ps.println("外星人要拜访地球！");
        ps.println("exit");
        ps.flush();
        //接收来自Server的信息
        String str=br.readLine();
        System.out.println(str);
        //关闭流
        ps.close();
        os.close();
        br.close();
        is.close();
        client.close();
    }
    private static void client1() throws UnknownHostException, IOException {
        //建立与指定服务器、端口的socket连接
        Socket client=new Socket("localhost",5687);
        //获得客户端的输出流，对应Server端的输入流
        OutputStream os=client.getOutputStream();
        PrintStream ps=new PrintStream(os);
        //要传输的数据
        ps.println("外星人要拜访地球！");
        ps.flush();

        //关闭流
        ps.close();
        os.close();
        client.close();
    }

}
