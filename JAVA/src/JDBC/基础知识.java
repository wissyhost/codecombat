package JDBC;
import java.sql.*;

/**
 * Created by wissy on 2015/12/16.
 */
/**
 * Jdbc就是Java Data Base Connection Java数据库连接
 * 一.数据库的连接方式(4种)
 *     1.Jdbc-Odbc桥接
 *          最早的java的连接数据库的方式
 *          Jdbc-->Odbc-->Db
 *          代表数据库:access
 *      2.Jdbc连接本地程序,本地程序连接远程数据库CS结构
 *          Jdbc-->数据库客户端-->数据库服务器
 *          代表数据库:db2
 *      3.Jdbc连接远程的web Service,web service 连接数据库,BS结构
 *          Jdbc-->web服务器-->数据库
 *      4.Jdbc直连
 *          jdbc-->数据库
 *          主流数据库都主持
 *          Sun公司提供数据库连接的接口,要求数据库厂商提供接口的实现类
 *          代表数据库:全部(除了access)
 * 二.Jdbc直连
 *      1.Java提供接口
 *      2.数据库提供的实现类,打成jar包.提供给开发者
 * 三.使用
 *      1.找到mysql的架包
 *      2.一般建议将包拷贝到当前的工程下
 *      3.导入架包.右击工程-->属性-->java build path-->libraries-->add jars-->选取刚才的架包 ok
 *          在Referenced Libraries出现的"奶瓶就可以"
 *      4.java提供的接口
 *          注意!!在java.sql下
 *             Driver,DriverManager,Connection,Statement,
 *             PreparedStatement,CallableStatement,REsultSet
 *      5.Jdbc连接的步骤(step)
 *          1.加载驱动
 *              Class.forName(包名.类名);
 *              目的:加载类到运行时系统,并且能被DriverManager管理
 *          2.获取数据库连接
 *              需要知道URL(IP,端口号,数据库名称),用户名,密码
 *            注意!!数据库不同,URL不同
 *              Mysql的URL地址
 *                  如jdbc:mysql://127.0.0.1:3306/test
 *                  如jdbc:mysql://127.0.0.1:3306?test或者其他非重要字段
 *                  127.0.0.1:数据库地址
 *                  3306:Mysql的默认端口
 *                  test:数据库名称
 *                  其他子段如字符集:useUnicode=true&characterEncoding=UTF-8在中文乱码时使用
 *              Connection 数据库连接对象
 *                  DriverManager.getConnection(URL,user,passwd);
 *           4.Statement 获取Statement,执行Sql语句的客户端
 *                  获取Statement的方法
 *                    连接名的.createStatement
 *                    这个对象主要功能是存放SQL的执行列表
 *           4.往列表中装SQL语句
 *              sql语句不需要写";"
 *              一次中放一个SQL语句
 *              executeUpdate 主要执行DML语句(insert ,update,delete)语句
 *              返回值是影响的行数
 *              executeQuery 主要执行DQL语句
 *              返回值是ResultSet结果集
 *              select ,from ,where,group by,having, order by,limit
 *              ResultSet方法
 *                  next(),表示如果有记录就,移动记录到下一条.如果是到了最后一条,返回false
 *                  getObject(int 索引),索引从1开始
 *                  getObject(String 字段名)
 *                      可以得到列的值
 *                  getString();
 *                  getInt();
 *                  getFloat();
 *                  getDate();这个Date是java.sql.Date;
 *                  ....
 *           5.关闭数据库连接
 *              先关Statement,后关Connection
 *
 * 不要在元数据里面写问号,如:表名,列名
 *
 *
 */
public class 基础知识 {
    public static void main(String[] args) {
        getConnection();
    }

    public static void getConnection() {
        Connection connection = null;
        Statement statement = null;
        try {
            //1.Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://127.0.0.1:3306?test";
            String user = "root";
            String passwd = "root";
            //2.Get Connection
            connection = DriverManager.getConnection(URL, user, passwd);
            //3.Get Statement
            statement = connection.createStatement();
            //4.Execute SQL
//            int i = statement.executeUpdate("INSERT INTO test.class (c_name,c_name2) VALUES ('aaaa','aaaa')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.class ");
            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+"\t");
                System.out.print(resultSet.getString(2)+"\t");
                System.out.println(resultSet.getString(3));
            }
//            System.out.println("修改了"+i+"条语句");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败啦,看看导包没有,");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库名?用户名?密码?确认都对了");
            e.printStackTrace();
        } finally {
            //Close Connection
                try {
                    if (statement != null)
                        statement.close();
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    System.out.println("数据库关闭异常");
                    e.printStackTrace();
                }
            }
    }
}
