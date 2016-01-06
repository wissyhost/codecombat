package Moble;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by wissy on 2015/12/8.
 */
public class DBUtil {
    static Connection connection=null;
    static PreparedStatement preparedStatement=null;

    public static PreparedStatement getConnection( String sql){
        FileInputStream fi=null;
        Properties properties=new Properties();
        try {
            properties.load(fi=new FileInputStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if (fi!=null)
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        //---------------------------------------
        String driverClassName=properties.getProperty("mysqlClass");
        String user= properties.getProperty("user");
        String passwd= properties.getProperty("passwd");
        String mysqlURL=properties.getProperty("mysqlURL");
        //------------------------------

        try {
             Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载异常");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(mysqlURL,user,passwd);
        } catch (SQLException e) {
            System.out.printf("数据库连接失败");
            e.printStackTrace();
        }
        try {
           preparedStatement=connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static void close(){
        if (connection!=null)
        try {
            if (!connection.isClosed())
                connection.close();

            if (!preparedStatement.isClosed())
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        DBUtil.getConnection();
//        DBUtil.close();
//    }
}
