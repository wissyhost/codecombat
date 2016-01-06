package JDBC;

/**
 * Created by wissy on 2015/12/18.
 */

import java.sql.*;

/**
 *事务:
 *  步骤:
 *      1.connection.SetAutoCommit(false);//事务开启
 *      2.connection.commit();事务提交
 *      3.connection.rollback();事务回滚
 */
public class 事务 {
    public void testTranscation(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306?test", "root", "root");

            connection.setAutoCommit(false);//事务不自动提交
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate("INSERT INTO test.class (c_id, c_name, c_name2) VALUES (14,'55','855')");
            statement.executeUpdate("UPDATE test.class SET c_name45='8888888888888888' WHERE c_id=14");
            statement.executeUpdate("UPDATE test.class SET c_name='8888888888888888' WHERE c_id=14");
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {

        }
    }

    public static void main(String[] args) {
        事务 s=new 事务();
        s.testTranscation();
    }
}
