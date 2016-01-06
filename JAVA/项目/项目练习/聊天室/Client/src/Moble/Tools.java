package Moble;

import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wissy on 2015/12/9.
 */
public class Tools<E> {
    public static byte[] createChecksum(String filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);          //<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 20px;">将流类型字符串转换为String类型字符串</span>

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5"); //如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
        int numRead;

        do {
            numRead = fis.read(buffer);    //从文件读到buffer，最多装满buffer
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);  //用读到的字节进行MD5的计算，第二个参数是偏移量
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }

    public static String getMD5Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring(1);//加0x100是因为有的b[i]的十六进制只有1位
        }
        return result;
    }


//    public ArrayList<Content> readMessage(String s){
    public E readMessage(String s){
//        File file=new File("message.content");
        File file=new File(s);
        E o=null;
        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            inputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(inputStream);
           o =(E) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("创建缓存文件");
//            ArrayList<Content> temp=new ArrayList<Content>();
//            E e1= new Objects();
            if ("message.content".equals(s)) {
                ArrayList<Content> temp = new ArrayList<Content>();
                new Tools().writeMessage(temp,s);
            }else if("myFriend.hashmap".equals(s)){
                Map temp = new HashMap();
                new Tools().writeMessage(temp,s);
            }
            o=(E) readMessage(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
                try {
                    if (objectInputStream!=null)
                        objectInputStream.close();
                    if (inputStream!=null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return o;
    }
    public void writeMessage(E o,String s){
        File file=new File(s);
        OutputStream outputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
           outputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (objectOutputStream != null)
                    objectOutputStream.close();
                if (outputStream!=null)
                    outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
