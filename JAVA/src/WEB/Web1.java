package WEB;

import java.io.*;
import java.net.*;

/**
 * Created by wissy on 2015/12/3.
 */

/**
 * CS与BS模式:
 * CS就是Client/Server,表示客户端连接服务器的程序 ,如QQ.
 * BS就是Browser/Server,表示浏览器连接服务器的程序 ,如新浪.
 * 1.CS要求客户机安装程序,由客户机分担一部分功能,可以缓解服务器压力
 * 2.BS不要求客户机安装程序,所有功能由服务器提供,服务器工作压力大
 * 3.BS比CS结构的项目更好推广
 * <p>
 * OSI七层结构
 * 1.物理层.主要提供网络简介的硬件支持,包括网卡网线
 * 2.数据链路层.提供数据通信的通道,协议等,只要表现为交换机等
 * 3.网络层.为物理设备提供网络地址,实现网络地址与物理地址之间的映射,如IP地址
 * 4.传输层.提供数据传输的要求,功能,如TCP,UDP
 * 5.回话层.提供点对点的连接,TCP建立连接有3次握手,断开连接有4次握手
 * 6.表示层.由于网络传输的数据很小,所有这层会对大数据进行分割,也提供数据加密的功能
 * 7.应用层.提供如http,ftp,mailTo等网络应用功能
 * TCP与UDP
 * 1.一个可靠一个不可靠
 * 2.一个差错控制开销大,一个差错控制开销小
 * 3.一个传输无限制,一个传输限制在64k以下
 * 4.一个需要连接建立,一个不需要建立连接
 * Scoket套接字
 * Scoket,客户端
 * ServerScoket服务端
 * <p>
 * Socket s=new Socket("192.168.1.1",5000)
 * InetAddress
 * 表示网络地址,对象里面有ip地址信息和域名
 * 常用方法:
 * getAllByName获取指定对象上的InetAddress对象
 * getHostAddress获取InetAddress下的IP地址
 * getHstName获取InetAddress下的主机名
 * 编码集
 * GB2312  简体中文
 * BIG5    繁体中文
 * ISO8859-1   英文
 * SHIFT-JIS   日文
 * UTF-8       国际通用字符集(包括世界上大多数国家的语言)
 * URL统一资源定位器
 * <p>
 * URL badiu=new URL("http://~~~~~~/a.html)  也叫爬虫
 * 方法:
 * openConnection() .获得URLConnection对象
 * <p>
 * URLConnection
 * 表示URL资源的连接对象
 * 常见方法:
 * getInputStream()获得连接对象的输入流
 * getOutputStream()获得连接对象的输出流
 */
public class Web1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        URL baidu = new URL("http://www.baidu.com");

        URLConnection baiducon = baidu.openConnection();

        InputStream in = baiducon.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        PrintStream ps = new PrintStream(new FileOutputStream("aa.html"));

        String temp = "";
        while ((temp = br.readLine()) != null) {
            ps.print(temp);
            ps.println();
        }
        ps.close();
        br.close();
        in.close();
    }

    public static void aa() throws IOException {
        Socket socket = new Socket();
//        Socket.setSocketImplFactory(new SocketImplFactory() {
//            @Override
//            public SocketImpl createSocketImpl() {
//                return null;
//            }
//        });
        InetAddress[] a = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress aa : a) {
            System.out.println(aa.getHostAddress());
            System.out.println(aa.getCanonicalHostName());

        }
        socket.bind(new InetSocketAddress(225));
        // URLEncoder a=new URLEncoder();
        // URLDecoder b=new URLDecoder();
        //encode to webbyte
        String aa = "你好!!!!!";
        String bb = URLEncoder.encode(aa, "utf-8");
        System.out.println(bb);

        System.out.println(URLDecoder.decode(bb, "utf-8"));

        System.out.println("行了");
//        Thread.sleep(100000);
        socket.close();
    }
}
