package DB;

/**
 * 表结构:
 * 表名 表示表的名字
 * 表中有列,也叫字段,如姓名,年龄...
 * 表中有行,也叫记录,如王永生的信息...
 * 表分类
 *  分为基本表,关系表
 *      1.描述信息内容的表称子为基本表
 *      2.描述表和表之间的内容的表叫做关系表
 * 表与表之间的关系
 *      1.一对一
 *          两个表中都有相同含义的唯一列
 *          一个员工表一个薪水表 他们什么关系呢?
 *                  员工表
 *              员工编号 员工姓名 员工等级
 *              001         王       1
 *                  薪水表
 *               员工编号    薪水
 *               001         20w
 *
 *      2.一对多
 *          部门的一条记录中对应员工表的多条记录,通常在多的表中(员工表)添加一列(是部门表中的表的主键的标号)
 *                  员工表(重表)
 *              员工编号 员工姓名 员工等级 部门编号
 *              001         王       1       99
 *              002         刘       1       99
 *                  部门表(主表)
 *              部门编号    部门名称
 *              99         开发部
 *      3.多对多
 *      有时候也叫双向一对多,学员的表的一条记录对应课程表的多条记录,
 *      课程表的一条记录对应学员表的多条记录,描述多对多,通常用一个关系表(成绩表)来描述
 *              学员表(主表)基本表
 *          学员编号 学员姓名 学员等级
 *          001         王       1
 *          002         刘       1
 *
 *              课程表(主表)基本表
 *          学院编号 课程名称
 *          c001         JAVA
 *          c002         MYSQL
 *
 *              成绩表(重表)关系表
 *          学员编号  课程编号    成绩
 *           001          c001       99
 *           001          c001       98
 *           002          c002       89
 *           002          c002       66
 *SQL 结构化查询语言
 *      遵循SQL99标准,这个时期没有彻底成型,因此,不同的数据库厂商的sql语句也略有不同
 *      SQL标准经历99,2013,2012
 *
 *     微软:.net体系 C# ,WinForm,Ado.net,Asp.net
 *     甲骨文:JAVAEE体系,Java,Oracle/Mysql,JDBC,JSP,Servelt....
 * SQL分类:
 *      DDL:数据等于语言 如:create,drop...;
 *      DML:数据库caozhong语言,如:insert,update,delect;
 *      DQL:数据查询语言,如:Select...;
 *      DTL:(TPL)数据事务语言如Commit,Rollback;
 *      DCL:数据控制语言,Grant,revoke;
 *      CCL:指针控制语句,Cursor;
 *      !!:建议命令全部用大写.提高效率,因为SQL是将小写转大写执行的,
 *      --Database:
 *          1.创建数据库
 *          Create database 数据库名称;
 *          2.删除数据库
 *           Drop database 数据库名称;
 *          3.使用数据库
 *          use 数据库名称;
 *          4.查看数据库
 *          Show databases;
 *      --Table
 *          1.表的内容
 *             1).列,记录,数据
 *                  a.数据
 *                      如,王某某,男,xx岁,编号多少....
 *                      i.数据类型
 *                      整型:int (Oracle:number) float
 *                      字符串类型:char varchar(Oracle:Varchar2)
 *                      日期类型:Data Time DtaTime TimeStamp(年月日时分秒毫秒)
 *                      大数据类型:Blob(二进制),(其他数据库:Clob(字符类型));
 *                      ii:列的定义语法
 *                          列名 数据类型 (默认值 约束);
 *                      iii:列的定义语法
 *                          create table 表名(
 *                          列1,
 *                          列2,
 *                          .....
 *                          [约束1,
 *                          约束2,
 *                          .....]
 *                          );
 *                          如:CREATE TABLE 1509a.student(
                                stu_id int AUTO_INCREMENT,
                                stu_name VARCHAR(10),
                                stu_sex CHAR(2),
                                 PRIMARY KEY(stu_id)
 *                                );
 *                                    +----------+-------------+------+-----+---------+----------------+
                                     | Field    | Type        | Null | Key | Default | Extra          |
                                     +----------+-------------+------+-----+---------+----------------+
                                     | stu_id   | int(11)     | NO   | PRI | NULL    | auto_increment |
                                     | stu_name | varchar(10) | YES  |     | NULL    |                |
                                     | stu_sex  | char(2)     | YES  |     | NULL    |                |
                                     | stu_date | datetime    | YES  |     | NULL    |                |
                                     +----------+-------------+------+-----+---------+----------------+
                                     4 rows in set (0.00 sec)
 *
 *                        iv:查看表结构
 *                              desc 表名;
 *                        v:查看全部表
 *                              show tables;
 *                         vi:删除表
 *                              drop table 表名;
 *                          vii:修改表
 *                              alter table 表名 操作(add,delect)(
 *                              列定义1,
 *                              列定义2,
 *                              .....
 *                              约束1,
 *                              约束2,
 *                              .....
 *                              如:ALTER TABLE student ADD (
                                 location VARCHAR(10)
                                 );
 *                              修改列:
 *                                  修改表中的列,一般情况下,类型不会有大的变动,
 *                                      如果变只能把类型从小变大,禁止变小,不要改变数据类型
 *                                      如:ALTER TABLE student MODIFY COLUMN location   VARCHAR(10);
 *                                      如果多列用","号隔开
 *                               删除列
 *                                  删除已存在的列
 *                                  alter table classes drop location;
 *                              注释:
 *                                  单行:用"-- "(--后至少有一个空字符,即空格),其他数据库没有"#"
 *                                  多行:用    杠 * *杠 (Oracle 必须在同一行)
 *   DML 添加记录
 *          insert into 表名[(列的列表)] values(值列表);
 *      如果列的列表省略 默认使用全部列
 *          如果表中允许全部为null
 *              可以这么写 insert into 表名 其中一列 values(null); 其他列默认不写为默认值
 *      查看表中所有数据
 *          select * from 表名;
 *       为表中部分赋值
 *          就是指定列中的字段,如果没有默认约束则为null
 *      Mysql独有的添加多条记录
 *             INSERT INTO test.`1509a.student` (stu_name, stu_sex, stu_date) VALUES ('44','男','2015-5-15'),('55','dd','2015-5-5')
 *      更新记录
 *              要修改的表1     赋值语句2                      那些记录进行修改3
 *              updata 表名 set 列1=value1,列2=value2,.... [Where 条件]
 *              如果一个列为空则表示 Stu_id is null 逻辑顺序 132
 *      删除记录
 *              要删除的表           删除那些记录
 *              delect from 表名 [where 条件];
 *       截断表
 *          truncate table 表名;
 *              直接从数据文件中删除表中的所有记录(不可恢复,一般是数据库管理员使用);
 *   IX:事务
 *      1.set autocommit=0(事务关闭) ;默认是1(事务关闭)
 *      start transaction ;第二中开启方式
 *      set 赋值命令
 *      autocommit 环境变量
 *      auto 自动 commit提交
 *      2.事务命令
 *          commit事务提交
 *          rollback事务回滚
 *       3.事务的生命周期
 *          打开事务开始,commit设置为0
 *          结束事务,遇到commit或者rollback为止;s
 *       4.设点,可以回滚到某点
 *          savepoint a;保存点
 *          rollback to 某点; a b c 是有顺序 若回到 a点 b c 两点失效了不可回
 *    X,约束
 *   主键	唯一键 检查   外键约束    不为空   默认
     primay key,unique,check,foregin key,not null,default(其他数据库不叫约束)
        Oracle空可以表示为 '' null都行,mysql只有null
 *      1.默认值,default
 *      建表时用
 *      create tablt student(
 *      stu_sex varchar(2) default '男';
 *      );
 *    约束还分为行级和列级
 *      1.有','号的为行级约束,表明约束本身占一行,
 *          可以约束多列,
 *      2.列级约束是在列的后面定义的约束,前面没有','号
 *      只能约束本列
 *      如:
 *             CREATE TABLE t_stu1(
 stu_id int(10) AUTO_INCREMENT NOT NULL PRIMARY KEY , -- 列级约束 自动增长 非空
 stu_name VARCHAR(30) NOT NULL ,
 stu_age int,
 stu_sex CHAR(2) DEFAULT '男',
 title varchar(40) not null,
 writer varchar(20) ,
 content longtext not null,
 date datetime,
 titlestyle text ,
 htmlon int not null,
 allowhtml int not null ,
 //(mysql)check忽略
 CHECK(stu_sex in('女','男')),  -- 行级的约束
 CHECK (stu_age between 0 and 150),
 CHECK(htmlon in (0,1)),
 CHECK(allowhtml in (0,1))
 );

 NOT NULL 非空约束 只能作为列级约束 表中个数没有限制
 unique 非空约束,表示这一列的数据不能重复,但是可以为null;
 可以为约束起名字 用 constraint 约束名  约束类型;
    行级unique约束可以起名字,列级不可以起名字
 *   行级约束可以约束多列,列级只能约束一列
 *   列级约束放在列的后面,行级约束放在','后面,在约束类型右面(约束列列表)
 *   CREATE TABLE t_stu1(
     stu_id int  UNIQUE ,
     stu_name VARCHAR(20) NOT NULL ,
     stu_aa int NOT NULL ,
     CONSTRAINT uni_name UNIQUE (stu_name,stu_aa)
 *    );
 *    //约束列表,即d_year,d_month,d_day都一样时才是一个约束
 *    CREATE TABLE t_data(
         d_year YEAR,
         d_month INT,
         d_day INT,
         context VARCHAR(100),
         UNIQUE (d_year,d_month,d_day)
  *       );
 *       主键约束 一个表最多有一个主键约束,主键约束的非空,唯一
 *       可以是行级也可以是列级
 * 自增长字段,修饰主键
         *  mysql:auto_increment 初始值是1,每次加1
         *  db2与sqlserver:identity
         *  Oracle:用sequence模拟
 *
 *
 *      */

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * 检查约束 check
 *   !!MYSQL 语法不支持check
 *          既可以列级也可以是行级
 *          只能约束一列
             * 语法:check boolean类型的值
             *  CREATE TABLE test.check (
             stu_sex CHAR(2) DEFAULT '男',
             check(stu_sex in('男','女'))
             );
    外键约束 foreign key
    语法:foreign key  (本表列名) references 主表 (列名);
         本表的这一列数据参考主表中的指定列的值
         通常定义在从表的对应列上,参照主表的应该是主键约束或者是唯一约束

*        从表添加数据的时候有限制,外键在主表中有值
 *        主表删除数据的时候若从表有记录则不能删除
 *
 *          级联删除 on delete cascade
 *              ALTER TABLE test.class_sore ADD FOREIGN KEY (c_id) REFERENCES class(c_id) ON DELETE CASCADE ;
 *              代码:CREATE TABLE test.class_sore(
                     c_id int ,
                     c_name VARBINARY(30),
                     FOREIGN KEY (c_id) REFERENCES class(c_id) ON DELETE CASCADE
                     );
 *          主表删除时,子表对应列设为null
 *          on delete set null
 *                  代码:CREATE TABLE test.class_sore(
                             c_id int ,
                             c_name VARBINARY(30),
                             FOREIGN KEY (c_id) REFERENCES class(c_id) ON DELETE SET NULL
                             );
 *
        代码:CREATE TABLE test.class (   -- 主表
                 c_id int AUTO_INCREMENT PRIMARY KEY ,
                 c_name VARCHAR(30)
                 );
                 INSERT INTO test.class (c_name) VALUES ('wissy') ;
                 INSERT INTO test.class (c_name) VALUES ('wissy1') ;
                 CREATE TABLE test.class_sore (   -- 从表
                 c_id int  ,
                 c_name VARCHAR(30),
                 c_sore VARCHAR(30),
                 FOREIGN KEY (c_id) REFERENCES test.class(c_id)
                 );
                 INSERT INTO test.class_sore (c_id, c_name, c_sore) VALUES (3,'ww','55'); --违反了外键约束
 *          代码:自建链接 表名的某一职位管理员是当前表中某一人
                 CREATE TABLE test.lender (
                 id int  AUTO_INCREMENT,
                 name VARCHAR(30)  ,
                 lender_name VARCHAR(30)  ,
                 lender_id INT,
                 PRIMARY KEY(id,name),
                 FOREIGN KEY (lender_id,lender_name) REFERENCES lender(id,name)
                 -- FOREIGN KEY (lender_name) REFERENCES lender(name)
                 );
 *           查询代码:
 *                          要显示的        两个虚表                                条件
                 SELECT t1.*,t2.name from test.lender t1 ,test.lender t2 WHERE t1.lender_id=t2.id;

 DQL  数据查询语言  查询语句
 都是由字句构成
 *              子句:前导关键字开始的语句:就是字句
 *                  如:insert into,update 表名,delete from 表名,create 表名....
 *                  在DQL语句中的字句通常都会生成一个虚表
 *                  我们看到的结果都是虚表中的内容
 *           DQL字句语法
 *              1.select 列
 *              2.from 表
 *              3.where 条件
 *              4.group by 组
 *              5.having 组条件
 *              6.order by 排序
 *              7.limit 限制(Mysql独有)
 *     学习DQL语句,要重点关注(字句作用,字句书写顺序,子句执行顺序)
 *   #####select字句
 *          select 子句表示挑选的数据,这个数据可以是列,也可以是表达式常量
 *          select子句会生成一个虚表,这个表是由列和行组成
 *          如果没有指定列的名字,值将作为列的名字显示
 *          例子:
 *          select 1;
 *          select 'abc';
 *          select  1+2;
 *
 *          为列取别名(如果别名有特殊字符或者特殊格式 要用 "" 双引号包括起来)(Oracle数据库如果是字母会自动大写)
 *          单引号 表示字符串
 *          双引号 表示特殊格式
 *          例子:select '张三' as 姓名,23 as 年龄;
 *          例子:select '张三'  姓名,23  年龄;(Oracle不成立)
 *     读取表中的列:
 *          SELECT c_id 学号,c_name 姓名 FROM test.class;
 *     from子句
 *      从哪个表中取数据,通常从数据文件中读取数据到内存中,执行顺序 from select 书写顺序 select from,
 *      语法:from [数据库名.]表名;
 *      包含常量列
 *          select t_stu2.*,1,'abc,'1900-3-5 12:23:25.123 from stu_2;
 *       包含计算列
 *          在计算时,一个数字与字符串相加,字符串会自动转换成数字参与运行,
 *          select t_stu2.*,1+2,1+3 from t_stu2;
 *          通常情况下我们会给表的非基本列取别名
 *       distinct 会对列的列表去重复
 *       select distinct 列的列表 from 表名;
 *          例子:
 *   通过旧表复制新表(没有约束)  实质是将虚表雪写入数据文件
 *   create table a_1  select * from a;
 *   通过查询旧表添加多条记录到新表(要求查询的数据类型必须一样)
 *   insert into  a_1  select * from a;
 *   只是添加与查询对应的数据
 *   insert into  a_1 (c_id,c_name)  select a_id,a_name from a;
 *   where 语句
 *      挑选行
 *       执行顺序 from, where,select
 *       书写顺序,select,from,where
 *       1.从数据文件中取出表放到内存中
 *       2.挑选符合要求的行记录
 *       3.挑选指定的列用于显示
 *      where [true] 表示符合要求
 *      [1]表示真 [0]表示假
 *      关系运算符
 *          1.=(等于) <=>(安全等于MYSQL专业) 如select null=null 返回null; select select null<=>null 返回1;
 *          is null(是null 为真),is not null(是null 为假)
 *          例如:select * from 表名 where 字段 is null;
 *          2.>;
 *          如果是整形数值 比较大小,如果是字符串,按照字典顺序比较
 *          select * from t_stu2 where stu_is>1;
 *          select * from t_stu2 where stu_name>'c';
 *          3.<; !=;>=;
 *          同上
 *         4.<=;<>;都表示不等于
 *         5.between 值1 and 值2
 *         表示查询值在值1和值2的之间,包括值1和值2
 *         select * from t_stu2 where stu_id between 1 and 2;
 *         6.in (值1,值2)
 *         表示等于值1或者等于值2;
 *         select * from t_stu2 where stu_id in (1,2)
 *         7.is null; is not null;
 *         8.like 模式匹配,主要应用与模糊查询(大小写是区分的但是MYSQL不区分想区分加 binary)binary按照字节比较,没有binary按照字符比较
 *          % 表示多个任意多个字符
 *          _ 表示一个任意字符
 *          select * from t_stu2 where stu_name like '%A%';
 *          select * from t_stu2 where stu_name like '_A%';
 *          select * from t_stu2 where stu_name like '_A_';
 *          select * from t_stu2 where binary stu_name like '_A_';
 *          select * from t_stu2 where stu_name like '___A_';第4个字符为A
 *         9.逻辑运算符
 *          not 取反
 *          and 逻辑与,同时
 *          or  逻辑或,或者
 *         优先级 关系>逻辑  逻辑运算符not>and>or 用()可以改变优先级
 *  排序:order by
 *      对查询的数据结果进行排序
 *      sac 表示升序,默认类型
 *      desc 表示降序
 *      书写顺序: select,from,where,order by
 *      执行顺序:from,where,select,order by
 *      例子: select * from 表名 where 字段 <=3 order by 要排序的字段 [排序类型]
 *          从数据文件中读取表到内存中
 *          选取符合条件的记录
 *          挑选表中的列
 *          岁对查询出来的数据结果进行排序 排序条件默认从小到大
 * 多列排序:
 *      order by 列1 [排序类型],列2[排序类型],...
 *      对select子句的查询出来的虚表 首先按照列1的排序规则排序,如果列1有相同的,对相同列 再按列2的排序规则排序
 *
 *

 */
public class Introduction {
    public static void main(String[] args) throws IOException {
        System.out.println((String) InetAddress.getLocalHost().getHostAddress());
        ServerSocket server=new ServerSocket(8888);
        ServerSocket server1=new ServerSocket(8887);
        ServerSocket server2=new ServerSocket(8889);
        server.close();
        server1.close();
        server2.close();

    }
}
