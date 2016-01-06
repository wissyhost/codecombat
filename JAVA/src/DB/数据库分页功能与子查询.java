package DB;

/**
 * Created by wissy on 2015/12/16.
 */

/**
 * 数据库分页功能
 * (mysql) limit[起始行],长度
 * 起始行默认为0,第0条数据也是一条数据
 *      书写位置,order by之后
 *      执行顺序,order by之后
 *      .
 *  select * from T_student limit 3,5;
 *
 * db2.sqlserver,oracle可以用top
 *  select * from T_student where stu_id in(select top 8 stu_id from t_student)
 *      and stu_id not in (select top 3 dtu_id from t_student)
 * oracle也可以使用rownum
 *      select * from (select t_student.*,rownum rn from t_student) where rn>=3 and rm<=5;
 *子查询
 *      在一条select语句中还包含了其他色select语句,外层色select是内层的select的子查询
 *      执行顺序:先执行子查询,再执行主查询
 *      子查询主要书写位置,where ,from ,having,次要order by ,select
 *      子查询,
 *          1.单行子查询
 *              一般指单行单列子查询,就是一个查询值
 *              需求:1.知道部门2的某人薪水
 *                   2.查询部门1里的与某人一样多的人
 *                   select stu_salsry drom t_student where team id=1 and stu_salary> (select stu_salary from t_student where where team=2 and stu_name ='某某人')
 *              关系运算符>,<,>=,<=,!=, between and
 *
 *              栗子:select * from t_student where stu_salary = (select stu_salary from t_student where  )
 *          2.多行子查询
 *             多行子查询,有一列多行构成
 *              关系运算符 in,not in,(>,<,<=,>=,!=) any,(>,<,<=,>=,!=) all
 *              select * from t_student where team_id=1
 *              and stu_salary in(select syu_salary from t_student where team_id=6);
 *          3.多列子查询
 *              查询结果是多多行多列
 *              关系运算符:同上
 *              需求:查询部门6与部门1中薪水和奖金一样的员工信息
 *                  select * from t_student where team_id=6 and (stu_salary,stu_comm) in (select stu_salary,stu_comm from t_student where stu_id =1002);
 *                  select * from t_student where team_id=6 and stu_salary in (select stu_salary from student where stu_id=1002) and stu_comm in (select stu_comm from student where stu_id=1002)
 *              any 任何一个 all 全部
 *                  比任何一个员工都大 > all()
 *                  比任何一个员工大   >  any()
 *                  select * from t_student where
 *           4.子查询在having中的应用(重点)
 *              需求:查询出工资比部门6的平均工资高的部门信息
 *              select team_id from t_student group by team_id having avg(stu_salary) >
 *              (select avg(stu_salary) from t_student where team_id=1)
 *              and team_id is not null;
 *           5.子查询在order by 中的应用(了解)(5.0有bug,升序,降序都是一样)
 *              需求:查询所有部门编号,按照平均工资降序排序
 *             select team_id from t_student order by (select avg(stu_comm) from t_student) desc;
 *              select * from class order by (select Length(c_name))desc;
 *           6.子查询在from中的应用(重点)
 *              子查询是一个续表,通常为这个续表定义一个表别名(MYSQL必须起别名)别名最好不要重复与比别的表名或者是字段
 *              需求:查询出部门平均工资比部门1的平均工资高的部门的员工信息
 *              select * from a (select stu_id ,stu_name,stu_salary from t_student where team_id =6) a;
 *               栗子:select a.* from  (select c_id,c_name2 from class) a where 1=1 order by c_id desc ;
 *           7.子查询在select中的应用
 *              要求单行单列
 *           8.子查询在insert into的应用(复制表记录)
 *                insert into from class select * from class1;
 *           9.子查询在create table 应用(复制表记录)
 *              create table class_bak desc class;
 *              create table class_bak (select * from class where 1=2);
 *           10.子查询在update中的应用(复制单条记录)
 *            update t_student_bak set stu_salary=(select stu_salary from t_student where stu_id=1003) where c_id=1003;
 *
 */
public class 数据库分页功能与子查询 {
}
