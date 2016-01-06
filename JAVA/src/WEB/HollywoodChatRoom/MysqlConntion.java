package WEB.HollywoodChatRoom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * Created by wissy on 2015/12/4.
 */
public class MysqlConntion {
    public static Connection getConn() {
        Properties p = new Properties();
        Connection connection = null;
        try {
            p.load(new FileInputStream("test.properties"));
        } catch (IOException e) {
            System.out.println("属性文件加载失败");
            e.printStackTrace();
        }
        String URL = p.getProperty("mysqlURL");
        String MysqlClass = p.getProperty("mysqlClass");
        String user = p.getProperty("user");
        String passwd = p.getProperty("passwd");

        try {
            Class.forName(MysqlClass);
        } catch (ClassNotFoundException e) {
            System.out.println("属性文件没有mysqlURL");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, user, passwd);
        } catch (SQLException e) {
            System.out.println("MYsql数据库连接失败");
            e.printStackTrace();
        }
//        Statement statement=null;
//        try {
//         statement = connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return connection;
    }

//    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
//        Connection conn = MysqlConntion.getConn();
//        Statement statement = conn.createStatement();
//        byte[] b="上课考试开始看看是".getBytes("utf8");
//        String str1="INSERT INTO test.charlog (fromHost, fromName, toHost, toName, date, contecnt) VALUES ('127.0.0.1'\" +\n" +
//                "                \",'wissy','127.0.0.1','wissy','2015-10-13','上课考试开始看看是');";
//        PreparedStatement ps= conn.prepareStatement(str1);
//        //ps.setString(1,new String(b));
//        System.out.println(ps.execute());
//        String sql = "SELECT * FROM test.charlog";
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()){
//            String s=resultSet.getString("contecnt");
//            System.out.println(s);
//        }

//    }
}
