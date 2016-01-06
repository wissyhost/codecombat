package IO;

/**
 * Created by wissy on 2015/11/17.
 */

import java.io.*;
import java.util.Arrays;

/**读文件
 * 流:
 *  1.有方向(单向)
 *  2.根据方法分为输入流和输出流
 *  3.有流里的数据类型
 *  4.根据这个类型分为字节流和字符流
 *  字节输入流:
 *      父类:InputStream
 *      子类:FileInputStream
 *          方法:
 *          available()  还能读多少
 *          close()     :关闭流
 *          read(byte[])    :读流,读到底返回-1
 *          read(byte[] ,int ,int)  :读流
 *   字节输出流:
 *      父类:OutputStream
 *      子类:FileOutputStream
 *      构造器:名字,是否追加ture追加false创建新的(可以省略)
 *          方法:
 *               close()                    :关闭流
 *               write(byte[])              :写流
 *               write(byte[] ,int ,int)     :写流
 *               flash();                   :刷新缓存区的数据到文件
 */
class CopyFileByByte{
    public  static void copyFileByByte(String resFim,String aimDir) throws IOException{
        //读文件
        InputStream in= new FileInputStream(resFim);
        byte[] b= new byte[in.available()];
        in.read(b);
        //写文件
        String aimFile=aimDir+new File(resFim).getName()+".bak";
        OutputStream out= new FileOutputStream(aimFile);
        out.write(b);
        out.flush();
        //先关输入在关输出
        out.close();
        in.close();

    }
        }
class testIO {
    public void inputStream() throws IOException {
        File file = new File("d:/aaa.txt");
        //创建一个输入流(指向一个File类型)
        InputStream inputStream = new FileInputStream(file);
        //创建一个byte[]数组
        // byte[] b= new  byte[inputStream.available()];
        //文件读取到数组中
        //  inputStream.read(b,0,b.length);
        //关闭流
        //inputStream.close();
//        String str= new String(b);
//        System.out.println(str);
        byte[] bb = new byte[5];
        int m = 0;
        while ((m = inputStream.read(bb)) != -1) {
            System.out.println(bb);
            System.out.printf("kkk");
        }
        inputStream.close();

//        System.out.print(to);
//        System.out.println(Hex);
    }
    //字符数据文件的导致如123转为321  ----比较常用
    public  void copyStrgDaoFilByStringe(String resFim,String aimDir) throws  IOException{

        if (new File(resFim).exists()) {
            InputStream in = new FileInputStream(resFim);
            String aimFile = aimDir + new File(resFim).getName() ;
            OutputStream out = new FileOutputStream(aimFile);
            byte[] b = new byte[in.available()];
          StringBuffer str=new StringBuffer();
            int m=0;
          while ((m=in.read(b))!=-1){
              str.append(new String(b).trim());
          }
            str.reverse();
            out.write(str.toString().getBytes());
            out.flush();
            out.close();
            in.close();
        }else{
            throw new IllegalArgumentException("文件找不到异常");
        }

    }
    //ASNLL数据的导致--不常用
    public  void copydaoFileByByte(String resFim,String aimDir,String formart) throws IOException{

        if (new File(resFim).exists()) {
            InputStream in = new FileInputStream(resFim);
            String aimFile = aimDir + new File(resFim).getName() ;
            OutputStream out = new FileOutputStream(aimFile);
            byte[] b = new byte[in.available()];
            byte[] c = new byte[in.available()];
            in.read(b);
            System.out.println(b[2]);
            for (int i = 0, j = b.length-1; i < b.length; i++, j--){
                c[j] = b[i];
            }
            System.out.println(c[2]);
            out.write(c);
            out.flush();
            //先关输入在关输出
            out.close();
            in.close();
        }else{
           throw new IllegalArgumentException("文件找不到异常");
        }

    }
    public  void copyLargeFileByString(String resFim,String aimDir) throws IOException{
        InputStream in= new FileInputStream(resFim);
        String aimFile=aimDir+new File(resFim).getName()+".bak";
        OutputStream out= new FileOutputStream(aimFile,true);
        byte[] b= new byte[50*1024*1024];//一次读50m
        int m=0;
        while ((m=(in.read(b)))!=-1){
                out.write(b,0,m);
        }
        out.flush();
        out.close();
        in.close();
    }
}
class  testOutputStream{
    public void outPutStream(String fileName,String str) throws IOException {
        //创建文件输出流,文件不存在创建,存在覆盖
        OutputStream out = new FileOutputStream(fileName,true);
        // 创建文件缓存区
        byte[] temp= str.getBytes();
        //写入数据
        out.write(temp);
        //关闭
        out.close();
    }
}
public class Io流 {

    public static void main(String[] args) throws IOException {
       long a= System.currentTimeMillis();

        long b=System.currentTimeMillis();
        System.out.println("时间:"+(b-a)+"毫秒");
    }
}
