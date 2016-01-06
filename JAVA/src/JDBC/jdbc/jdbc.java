package JDBC.jdbc;

import JDBC.tools.PropertiesTools;

import java.sql.*;

/**
 * Created by wissy on 2015/12/17.
 */
public class jdbc {
    protected static Connection conn;
    protected static java.sql.Statement stmt;
    protected static ResultSet rs;
    public static void main(String[] args) {
        /**
         * 第三步
         * statement
         * PreparedStatement 可预处理的Statement
         *   ?表示一个变量,?有索引,索引从1开始
         * CallableStatement,可呼叫的Statement,通常用在数据库的存储过程
         *
         * PreparedStatement与Statement的区别
         * 1.PreparedStatement是Statement的子接口
         * 2.Statement在创建对象时不放sql语句,PreparedStatement在创建时要加入预处理的sql语句
         * 3.Statement的sql不能有变量.PreparedStatement可以用?变量
         * 4.对单一的sql执行效率,PreparedStatement效率高
         * 5.安全上.PreparedStatement防止SQL注入的发生
         *
         * SQL注入:select * from user where username='tom' and passwd='122'
         *  tom-->' or  '1' = '1
         *
         */
        try {
            if (conn == null || conn.isClosed()) {
                try {
                    /**
                     * 建议使用属性文件
                     */
                    Class.forName(PropertiesTools.getDBMessage("mysqlClass"));
                    conn = DriverManager.getConnection(PropertiesTools.getDBMessage("mysqlURL"), PropertiesTools.getDBMessage("user"),
                            PropertiesTools.getDBMessage("passwd"));

                    PreparedStatement preparedStatement = conn.prepareStatement("SELECT  * FROM ?");


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void close() {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {

        }
    }
}
