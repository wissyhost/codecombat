package IO;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by wissy on 2015/11/19.
 */
public class RandomAccessFile_Dome {
    public static void randomAccoessFile() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("a.txt", "rw");
        double[] doubles = {
                2.55f, 4.25f, 3.66f, 0.2225f
        };
        for (double tempdou : doubles) {
            randomAccessFile.writeDouble(tempdou);
        }
        randomAccessFile.close();
        randomAccessFile = new RandomAccessFile("a.txr", "rw");
        randomAccessFile.seek(2 * 8);//跳过8个bit即一个double数据
        randomAccessFile.writeDouble(2.36);
        randomAccessFile.writeDouble(20.36);
        randomAccessFile.close();
        randomAccessFile = new RandomAccessFile("a.txt", "rw");
        double a;
        for (int i = 0; i < 4; i++) {
            System.out.println(randomAccessFile.readDouble());
        }
    }

    public static void tset() throws IOException {
        RandomAccessFile randomAccessFile1 = new RandomAccessFile("a.txt", "rw");
        randomAccessFile1.writeDouble(3.26);//8
       // randomAccessFile1.write(2);//4
        randomAccessFile1.writeUTF("ffff");//4+2
        randomAccessFile1.writeUTF("你好");//2*3+2
        randomAccessFile1.writeChar('c');//2
        randomAccessFile1.writeFloat(2.35f);//4
        randomAccessFile1.writeBoolean(true);//1
        randomAccessFile1.writeShort(523);//20
        randomAccessFile1.writeLong(55555555555l);//8
        randomAccessFile1.close();
        randomAccessFile1 = new RandomAccessFile("a.txt", "rw");
        randomAccessFile1.skipBytes(8);
        randomAccessFile1.skipBytes(6);
        randomAccessFile1.skipBytes(8);
        randomAccessFile1.writeChar('l');

//         randomAccessFile1.writeBoolean(false);
        randomAccessFile1.seek(0);
        System.out.println(randomAccessFile1.length());
        System.out.println(randomAccessFile1.readDouble());
//        System.out.println(randomAccessFile1.read());
        System.out.println(randomAccessFile1.readUTF());
        System.out.println(randomAccessFile1.readUTF());
        System.out.println(randomAccessFile1.readChar());
        System.out.println(randomAccessFile1.readFloat());
        System.out.println(randomAccessFile1.readBoolean());
        System.out.println(randomAccessFile1.readShort());
        System.out.println(randomAccessFile1.readLong());
        randomAccessFile1.close();

    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile_Dome.tset();
    }
}
