package IO;

import java.io.*;

/**
 * Created by wissy on 2015/11/18.
 */
//拷贝文件
public class PrintStrean_Demo {
    public  void printStream_Dome(String resFileName,String aimFile) throws IOException {
        BufferedInputStream isr = new BufferedInputStream(new FileInputStream(resFileName));
        PrintStream ps = new PrintStream(new FileOutputStream(aimFile));
        byte[] b = new byte[isr.available()];
        isr.read(b);
        ps.write(b);
        ps.println();
        ps.flush();
        ps.close();
        isr.close();
    }
}
