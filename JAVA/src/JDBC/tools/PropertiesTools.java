package JDBC.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wissy on 2015/12/17.
 */

/**
 * 属性文件的工具类
 * 用于提供两个属性文件的读取
 *
 *
 * 静态  只是方法不占空间,调用一次,不要加载,可以多人读取
 *
 */
public class PropertiesTools {
    private static Properties db=new Properties();
    private static Properties sql=new Properties();
    static {
        try {
            db.load(new FileInputStream("src/JDBC/db.properties"));
            sql.load(new FileInputStream("src/JDBC/sql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getDBMessage(String key){
        return db.getProperty(key);
    }
    public static String getSqlMessage(String key){
        return sql.getProperty(key);
    }
}
