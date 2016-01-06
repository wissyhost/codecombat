package WEB.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by wissy on 2015/12/4.
 */
public class C1 {
    public static void main(String[] args) throws IOException {
        //建立与指定服务器、端口的socket连接
        Socket client=new Socket("localhost",5687);
        //获得客户端的输出流，对应Server端的输入流
        OutputStream os=client.getOutputStream();
        PrintStream ps=new PrintStream(os);
        //要传输的数据
        ps.println("788");
        ps.flush();

        //关闭流
        ps.close();
        os.close();
        client.close();
    }
}
