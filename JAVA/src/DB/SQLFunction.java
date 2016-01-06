package DB;

/**
 * Created by wissy on 2015/12/14.
 */

/**
 * 函数
 * 	1.分类
 * 		按照输入数据
 * 			单行函数,和多行函数
 * 		按照类型
 * 			字符串函数,数字函数,日期函数,转换函数,其他..
 * 2.单行函数
 * 	函数是由函数名称,输入参数,返回值构成
 * 	输入参数是一个数.返回一个数,就是单行函数
 * 	select concat('abc','123'),now();
 * 	    concat:函数名
 * 	    ''abc,'123':参数列表
 * 	    concat('abc','123') :返回值
 * 	3.多行函数
 * 	    输入多个值返回一个值.就是多行函数
 * 	    栗子:select count(*) from t_stu2_1;
 * 	        select max(salary) from t_students;查看记录中最大值
 * 	        查询表中的记录数
 * 	4.字符串函数
 * 	    数据库下标从1开始
 * 	    1.连接:concat
 * 	    2.已知字符得到ASC值
 * 	    3.已知索引.得到对应字符
 * 	    4.已知字符,得到对应的索引
 * 	    5.截取字符串
 *
 */
public class SQLFunction {
}
