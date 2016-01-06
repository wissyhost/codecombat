package WEB.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wissy on 2015/12/4.
 */
class Mythread extends Thread{
private Socket socket=null;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream ips=null;
        OutputStream ops=null;
        BufferedReader bf=null;
        PrintStream ps=null;
        try{
            ips=socket.getInputStream();
            ops=socket.getOutputStream();
            bf= new BufferedReader(new InputStreamReader(ips));
            ps=new PrintStream(ops);
            String s=bf.readLine();
            System.out.println("客户端主机名称:"+socket.getInetAddress().getHostName()+"客户端主机地址:"+socket.getInetAddress().getHostAddress());
            System.out.println("信息请求:"+s);
            ps.print(s+"已收到你的请求");
            ps.flush();
        }catch (IOException e){

        }finally {
                try {
                    if (ips!=null)
                    ips.close();
                    if (ops!=null)
                        ops.close();
                    if (bf!=null)
                        bf.close();
                    if (ps!=null)
                        ps.close();
                    if (socket!=null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }
    }
}
public class ThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ser=new ServerSocket(8888);
        boolean b=true;
        while (b){
            Socket so=ser.accept();
            Mythread mythread=new Mythread();
            mythread.setSocket(so);
            mythread.start();
        }
    }

}
