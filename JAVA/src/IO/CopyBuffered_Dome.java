package IO;

/**
 * Created by wissy on 2015/11/18.
 */

import java.io.*;

/**
 * System类
 * 输出流有out.in和err
 * 需要注意的是err和其他的不在一个线程中
 */

/**
 * File
 * 字节流byte类型 保存时用byte类型
 * 字符流char类型  保存时用Char类型
 * 节点流      与硬盘直接连接的
 *          Reader/Writer超类
 *          有常用的FileRead/FileWrite两个孙子类
 * 父　类    InputStream             OutputStream              Reader               Writer
 * 文　件   *FileInputStream       FileOutputStrean         FileReader         FileWriter 文件进行处理的节点流
 * 过滤流      又叫处理流,节点转字符但是字符不能转节点    缓存流--->过渡流--->字符流--->节点流
 *              BufferedReader/BufferedWriter可以实例化,连接的是
 *              　  父　类     InputStream                     OutputStream                       Reader                               Writer
 *              　  缓冲流    *BufferedImputStrean BufferedOutputStream         BufferedReader                BufferedWriter
 *              ----需要父类作为参数构造，增加缓冲功能，避免频繁读写硬盘，可以初始化缓冲数据的大小，由于带了缓冲功能，所以就写数据的时候需要使用flush方法咯
 *                 转换流    *InputStreamReader          OutputStreamWriter
 *              - 要inputStream或OutputStream作为参数，实现从字节流到字符流的转换
 *                 数据流    *DataInputStream            DataOutputStream
 *              -提供将基础数据类型写入到文件中，或者读取出来，为什么要有这个流呢？看这样的分析，如果没有这种流的话，有一个long，本身只占8个字节，如果我要写入到文件，需要转成字符串，然后在转成字符数组，那空间会占用很多，但是有了这种流之后就很方便了，直接将这8个字节写到文件就完了。。是不是既节约了内存空间有让程序写起来更加方便简单了呐。写倒是很简单，但是读取的时候就注意了，根据读取的数据类型，指针会往下移，所以你写的顺序必须要和读的顺序一致才能完成你正确的需求。


 */
class ReaderTest {
    public  void readertest(String fileName) throws IOException {
        Reader reader = new FileReader(fileName);
        char[] chars= new char[20];
        int m= 0;
        if ((m=reader.read(chars))!=-1){
            System.out.println(new String(chars));
        }
        reader.close();
    }
}
class WriterTest{
    public static  void  writeerTest(String fileName) throws  IOException{
        Writer writer= new FileWriter(fileName,true);
        char[] c="kjdsjj基金大siis及计算机四级解释解释解释解释就".toCharArray();
        writer.write(c);
        writer.flush();
        writer.close();
    }
}
class CopyFileByChar{
    public static void copyFileByChar(String resFileNme,String aimFileName) throws  IOException{
        Reader reader= new FileReader(resFileNme);
        Writer writer= new FileWriter(aimFileName);
        char[] c=new char[20];
        int m=0;
        if((m=reader.read(c))!=-1){
            writer.write(c);
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
class CopyFileByByteToChar{
    public static void copyFileByByteToChar(String resFile,String aimFile) throws IOException {
        //字节流
       InputStream inputStream= new FileInputStream(resFile);
        OutputStream outputStream=new FileOutputStream(aimFile);
        //过渡流
        InputStreamReader inputStreamReader= new InputStreamReader(inputStream);
        OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
        //----------------
        char[] c= new char[100];
        int m=0;
        while ((m=inputStreamReader.read(c))!=-1){
            outputStreamWriter.write(c);
        }
        outputStreamWriter.flush();
        outputStreamWriter.close();
        outputStreamWriter.close();
        inputStreamReader.close();
        inputStream.close();
    }
}
public class CopyBuffered_Dome{
    public static void buffered(String resFile,String aimDFile) throws  IOException{
    Reader reader= new FileReader(resFile);
         BufferedReader br= new BufferedReader(new FileReader(resFile));
         BufferedWriter bw= new BufferedWriter(new FileWriter(aimDFile));
        String str;
        while (((str=br.readLine())!=null)){
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }


}