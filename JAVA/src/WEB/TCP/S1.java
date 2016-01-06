package WEB.TCP;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by wissy on 2015/12/4.
 */
public class S1 {
    public static void main(String[] args) throws IOException {
        ServerSocket service1=new ServerSocket(4565);
        boolean bb=true;
        while (bb){
            Socket so=service1.accept();
            BufferedReader buf=new BufferedReader(new InputStreamReader(so.getInputStream()));
            String a=buf.readLine();
            System.out.println(a);
         buf.close();
            so.close();
        }
        service1.close();

    }
}
