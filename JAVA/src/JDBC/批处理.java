package JDBC;

import java.sql.*;

/**
 * Created by wissy on 2015/12/18.
 */

/**
 * 批处理:
 * 批处理一般用于Insert语句
 * 插入n条语句
 */
public class 批处理 {
    public static void exceBatch() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306?test", "root", "root");
            connection.setAutoCommit(false);//事务不自动提交

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test.class (c_name, c_name2) VALUES (?,?)");
            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1, "aaa4578");
                preparedStatement.setString(2, "" + new java.sql.Date(System.currentTimeMillis()).toLocalDate());
                preparedStatement.addBatch();
            }
            int[] m = preparedStatement.executeBatch();
            for (int i : m) {
                System.out.println(i);
            }
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
        } finally {

        }
    }

    public static void main(String[] args) {
        new 批处理().exceBatch();
    }

}
