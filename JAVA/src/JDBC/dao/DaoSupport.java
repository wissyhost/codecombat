package JDBC.dao;

import JDBC.tools.PropertiesTools;

import java.sql.*;

/**
 * Created by wissy on 2015/12/17.
 */

/**
 * 父类
 * DB级别
 */
public class DaoSupport {
    protected Connection conn;
    protected Statement stmt;
    protected ResultSet rs;

    protected void ConnectionDB(){
        try {
            if (conn == null||conn.isClosed()) {
                try {
                    /**
                     * 建议使用属性文件
                     */
                    Class.forName(PropertiesTools.getDBMessage("mysqlClass"));
                    conn = DriverManager.getConnection(PropertiesTools.getDBMessage("mysqlURL"), PropertiesTools.getDBMessage("user"),
                            PropertiesTools.getDBMessage("passwd"));
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
            /**
             * .....
             */
        } catch (SQLException e) {

        }
    }

}
