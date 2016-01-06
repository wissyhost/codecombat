package IO;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by wissy on 2015/11/16.
 * 文件名过滤
 */
//------------------1.过滤器实现FilenameFilter方法
class  Myfirst implements FilenameFilter{
    @Override
    public boolean accept(File dir, String name) {
        if("xxx".equals(name)||name.length()<=6){
            return true;
        }
        return false;
    }
}

public class Fiii{
    public static void main(String[] args) {
        //运行
        new Fiii().test();

    }

    //------------------2.调用方法,实现过滤规则
    public void test() {
        File file = new File("d:/");
        String[] filename = file.list(new Myfirst());
        for (int i = 0; i < filename.length; i++) {
            System.out.println(filename[i]);
        }
    }


}
