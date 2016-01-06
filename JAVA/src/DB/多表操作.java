package DB;

/**
 * Created by wissy on 2015/12/18.
 */

/**
 *多表操作(表的数量大于1)
 *  1.多表操作的类型
 *      相等连接,不等连接,内连接,外连接(左外连接,右外连接,全外连接),自连接
 *  2.相等连接
 *     select stu_id,stu_name,tname  from t_student t,team t1 where t.team_id=t1.tid;
 *     a.从数据文件中选取两张表,加载到内存中
 *     b.依据条件进行连接
 *     c.挑选连接后的虚表列
 *      where t.team_id=t1.tid; --连接条件
 *      n张表有n-1个连接条件,写在where子句
 *      如果条件缺失或者条件失效,就形象了笛卡尔集,编写select 语句时,应经量避免笛卡尔集,形成资源浪费
 *     栗子:select class.c_id,class.c_name,class_sore.c_id from class,class_sore ;
 *     总表:一个表的一行与另一个表的记录进行叠加,形成笛卡尔集
         +------+---------+------+
         | c_id | c_name  | c_id |
         +------+---------+------+
         |    1 | wissy   |    4 |
         |    1 | wissy   |    5 |
         |    3 | a       |    4 |
         |    3 | a       |    5 |
         |    4 | b       |    4 |
         |    4 | b       |    5 |
         |    5 | c       |    4 |
         |    5 | c       |    5 |
         |    6 | d       |    4 |
         |    6 | d       |    5 |
         |    7 | e       |    4 |
         |    7 | e       |    5 |
         |    8 | c       |    4 |
         |    8 | c       |    5 |
         |    9 | c       |    4 |
         |    9 | c       |    5 |
         |   10 | c       |    4 |
 *       |   10 | c       |    5 |
 *     where条件以后
 *       +------+--------+------+
         | c_id | c_name | c_id |
         +------+--------+------+
         |    4 | b      |    4 |
         |    5 | c      |    5 |
*        +------+--------+------+
 *
 *
 *  3.迪卡尔集
 *  4.不等连接
 *      连接条件不是等号
 *      select stu_name,stu_salary,lid from t_student,stulevel where stu_salary between llow and height;
 *   5.内连接
 *      更相等连接类似
 *      select * from t_student s inner join team t on s.team_id=t.team_id;
 *      inner join team t 内连接的另外一张表
 *      on s.team_id=t.team_id 内连接的条件
 *      条件子句
 *      where --挑选行
 *      having --挑选组
 *      on  -- 连接条件
 *    6.外连接
 *       a.左外连接
 *          关键字:left outer join on
 *          select *
 *          from t_student  -- 基准表
 *          left outer join team -- 左外连接team表
 *          on t_student.team_id=team.tid; --连接条件
 *          基准表:t_student
 *       注意!! 基准表为参照都显示,连接表与基准表匹配,匹配上的显示具体内容,匹配不上的显示null
 *       b.右外连接
 *       关键字:right outer join on
 *          select *
 *          from t_student      -- 外连接表
 *          right outer join team -- 右外连接team表(基准表)
 *          on t_student.team_id=team.tid; --连接条件
 *          基准表:team
 *       c.全外连接 (MYSQL不支持)
 *          关键字:full outer join on
 *          select *
 *          from t_student          -- 基准表
 *          full outer join team -- 全外连接team表
 *          on t_student.team_id=team.tid; --连接条件
 *          基准表:t_student
 *          显示左外连接,后是右外连接,最后相同记录留一份
 *       d.自连接
 *          自己连自己
 *          select s.stu_name 学员名字,s.stu_address,t.stu_name 组长名字
 *          -- 从一个数据表中加载,在内存中形成两个虚表
 *          -- 要求为每个虚表起别名
 *          from t_student s,t_student t
 *          where s.stu_lender_id=t.stu_id;
 *       e.Union和Union all
 *          两个不同的是Union是去掉重复,Union 不去重复
 *          上下连接方式
 *          select 列的列表 类型要匹配
 *          新的结果集的列名就是第一个select 的列名
 *          select stu_id,stu_name,1 from t_student
 *          union all
 *          select stu_id,stu_name,2 from t_student
 *          union all
 *          select stu_id,stu_name,3 from t_student
 *          union all
 *
 *           select c_id as num from  class union all select c_id  from  class;
 *
 *
 */
public class 多表操作 {
}
