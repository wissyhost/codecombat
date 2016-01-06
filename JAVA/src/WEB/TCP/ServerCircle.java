package WEB.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCircle {

    private static void server3() throws IOException {
        //创建一个ServerSocket，指定一个没有使用端口号，端口号要大于1024
        ServerSocket server=new ServerSocket(5679);
        //开始监听端口
        boolean b=true;
        while(b){
            Socket accept=server.accept();
            //获得Client端的数据流（包括输出和输入），
            InputStream is=accept.getInputStream();
            BufferedReader br=new BufferedReader
                    (new InputStreamReader(is));
            OutputStream os=accept.getOutputStream();
            PrintStream ps=new PrintStream(os);
            //获得客户端的数据内容
            String str=br.readLine();
            System.out.println(accept.getInetAddress().getHostName()+":"+str);
            //给客户端传递数据
            if(str.equals("exit")){
                ps.println("exit");
            }else{
                ps.println("您的信息已收到，信息内容是："+str+"这是服务器"
                        +accept.getLocalAddress()+"的声音");
            }
            if(str.equals("exit")){
                System.out.println("服务器停止！");
                break;
            }
            //关闭流
            ps.close();
            os.close();
            br.close();
            is.close();
            accept.close();
        }
        server.close();
    }
    public static void main(String[] args) throws Exception {
        server3();
    }

}
