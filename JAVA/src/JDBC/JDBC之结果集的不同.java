package JDBC;


import java.sql.*;

/**
 * Created by wissy on 2015/12/18.
 */
public class JDBC之结果集的不同 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8"
                , "root", "root");
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,//结果集可以滚动,不能实时反映数据库的内容
                ResultSet.CONCUR_UPDATABLE);//结果集可以更新到数据库
        String sql = "SELECT * FROM class";
        ResultSet resultSet = statement.executeQuery(sql);
        //指针默认在顶层0行,next一次移动一次行号加一行
        resultSet.last();//移动到最后一行
        int row = resultSet.getRow();//获取行号
        System.out.println("总共:"+row+"行");//打印行号

        resultSet.first();//移动到第一行
        while (resultSet.next()){
            System.out.print(resultSet.getString(1)+"\t");
            System.out.print(resultSet.getString(2)+"\t");
            System.out.println(resultSet.getString(3)+"\t");
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
