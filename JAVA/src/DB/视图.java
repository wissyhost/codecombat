package DB;

/**
 * Created by wissy on 2015/12/21.
 */

/**
 *view 视图,是一个逻辑结构与表对应.
 * 要求:select后面的语句必须能正常执行
 *
 * 查看所有的视图
 * select table_name from information_schema.tables
 * where table_schema='数据库名' and table_type='view';
 * 栗子:
 *  create view v_student as select * from t_student where t_team=6;
 *  数据在t_student里面
 * 查询视图 select * from t_student;
 * 视图要求
 *  as后面的select语句必须能正常执行
 *  如果没有就创建,有就替换:or replace:
 *  栗子2:
 *  create or replace view v_student as select * from t_student;
 *  视图分类
 *      简单视图:as 后面只是select只是涉及到单表,没有group by,distinct等复杂的子句
 *              一般只包含select ,from ,where,order by子句
 *      复杂视图:As后面的select涉及多表.涉及子查询,分组,计算列,等等
 *      简单视图有可能可以执行DML操作,复杂视图不可以
 *      对视图进行DML操作(强烈不建议使用):
 *          insert into v_student (stu_id,stu_name,team_id) values(10,'tom',6);
 *       添加约束:with check option ,对该视图的DML操作将检查where子句 操作符合条件的允许DML操作,不符合的不允许条件,写在where 后面
 *       对视图重新定义列名: 隐藏表的列名,有助于提高安全性
 *       栗子:create or replace view v_student(ID,name) as select t_id,t_name from t_student;
 *      复杂视图:
 *       create or replace view v_student
 *       as
 *       select max(salary),min(salary),avg(salary) from t_student group by team_id order by avg(salary) deac;
 * 存储过程(相等于数据库编程):
 *  从存储过程开始,属于数据库编程部分(思想一样,Mysql语法)
 *      1.delimiter表示sql语句执行的符号;
 *      栗子: delimiter // 表示以//为dql语句执行的符号
 *      栗子: delimiter $$ 表示以$$为dql语句执行的符号
 *      2.begin
 *        end
 *        表示语句块,也表示一个范围,相当于java中的{ }
 *      3.变量
 *          分为用户变量(给指定用户使用的变量,相当于全局变量)和局部变量(在begin end里面使用的变量)
               栗子:用户变量用@a开始
               a表示局部变量
 *          给变量赋值
 *              set 变量=值;
 *              select 表达式 into 变量 from...
 *              把表达式数据放在对应的变量里面
 *       4.存储过程
 *       #set @a=0; -- 定义变量
 *       delimiter $$
 *       create procedure pro_test1()
 *       begin
 *          select count(*) from class;
 *       end
 *       $$
 *       delimiter ;
 *       调用存储过程
 *          call  存储过程名();
 *       参数列表
 *          输入输出符号 变量名 类型
 *          输入输出符号
 *              in表示输入参数,由外部提供数据
 *              out表示输出参数,给外部提供数据
 *              inout 表示输入输出参数,
 *              既可以从外部获得数据,也可以给外部提供数据
 *              栗子:
 *              set @count=0;-- 定义一个用户变量,放6组学员的
 *              set @team_id=6; -- 定义一个用户变量,赋值为6
 *              delimiter $$    -- 改变执行符合
 *              drop procedure pro_test1 $$ -- 删除存储过程
 *            create procedure pro_test1(in tid int,out cnt int)
 *           begin
 *           -- 为count赋值
 *             select count(*) into cnt  from class where team_id=tid ;
 *              end
 *          $$
 *           delimiter ; -- 恢复命令执行符号
 *           call pro_tset1(@team_id,@count);-- 调用存储过程
 *           select @count; --查看返回结果
 *
 */
public class 视图 {
}
