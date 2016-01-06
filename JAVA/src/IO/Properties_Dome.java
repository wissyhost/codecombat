package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by wissy on 2015/11/19.
 */

/**
 * properties!! 属性类
 * 是HashTable的子类继承了他的特征和成员
 * Properti类的key和value是String类型
 * 具有自己的方法.常见的有
 *          setproperties(String key.String value)
 *          getproperties(String key)
 *          load(InputStream)把属性文件的数据加载到properties中
 *          store(OutputStream,String)把数据存储到文件中
 *  多应用于项目的配置,页面信息,错误信息,数据库信息 .数据库语句等场合中
 *
 * 和HashMap类似但是它是String的key和value
 * 用setProperty放数据
 * 用getProperty取数据
 */
public class Properties_Dome {
    public static void test() throws IOException{
        Properties properties = new Properties();
        //设置属性 key为String value为String
        properties.setProperty("属性", "llll");
        properties.setProperty("passwd", "1555");
        System.out.println(properties);
        //读属性文件
        properties.load(new FileInputStream("属性文件.properties"));
        //写入属性文件
        //"...."为注释,可以为空
        properties.store(new FileOutputStream("属性文件.properties"),"this is backFile");
        //通过key去取value
        properties.getProperty("usernmae");
        System.out.println(properties.getProperty("属性"));
        properties.clear();

        /**
         * 国际化
         */
        ResourceBundle resourceBundle=ResourceBundle.getBundle("account", Locale.CHINA);
        System.out.println(resourceBundle.getString("username"));


    }

    public static void main(String[] args) throws IOException {
        test();
    }

}
