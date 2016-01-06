package IO;

import java.io.*;

/**
 * Created by wissy on 2015/11/18.
 */
public class CopyFileByBuffer_Demo {
    public static void copyFileByBuffer(String resFileName, String aimFileName) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(aimFileName));
        byte[] b = new byte[bis.available()];
        bis.read(b);
        bos.write(b);
        bos.flush();
        bos.close();
        bis.close();
    }
}
class  DataIOSteam_Demo{
    public static void dataOutPutStream(String fileName) throws  IOException{
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(fileName));

        char[] c={'a','f','f','h','l'};
        int[] i={23,56,85,96,2};
        double[] d={23.3,26.6,.556,.6,23.1,20};
        String[] s={"kk","ll","kkkks","ddf","fdddd"};

        for (int j = 0; j < 5; j++) {
            dos.writeChar(c[j]);
            dos.writeChar('\t');
            dos.writeInt(i[j]);
            dos.writeChar('\t');
            dos.writeUTF(s[j]);
            dos.writeChar('\t');
            dos.writeDouble(d[j]);
        }
        dos.flush();
        dos.close();
    }
    public static void dataInPutStream_Demo(String fileName) throws  IOException{
        DataInputStream dis=new DataInputStream(new FileInputStream(fileName));

        char[] c=new char[5];
        int[] i=new int[5];
        double[] d=new double[5];
        String[] s=new String[5];

        for (int j = 0; j < 5; j++) {
            System.out.println(""+dis.readChar()+dis.readChar()+dis.readInt()+dis.readChar()+dis.readUTF()+dis.readChar()+dis.readDouble());
        }
        dis.close();
    }
}


