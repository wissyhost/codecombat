select max(length(SNAME)) from student;
select count(*) from test.student;

INSERT INTO chat.user_feiend (user_id, user_name, friend_id, friend_name, friend_date) VALUES (11,1,12,2,'2015-12-12');

drop TABLE java_objects;
CREATE TABLE test.java_objects (
  id INT AUTO_INCREMENT,
   name varchar(60),
   object_value BLOB,
   primary key (id));

DELETE FROM chat.char_user WHERE chat.char_user.user_id>1;
CREATE TABLE T_team(
  t_id int NOT NULL PRIMARY KEY ,
  t_name VARCHAR(30),
  t_city VARCHAR(80)
);

CREATE TABLE T_student(
  stu_id INT PRIMARY KEY ,
  stu_name VARBINARY(10) NOT NULL ,
  stu_address VARCHAR(80) NOT NULL ,
  stu_birthday DATE NOT NULL,
  stu_salary FLOAT NOT NULL ,
stu_comm FLOAT,
stu_leader_id INT,
  stu_team INT,
  FOREIGN KEY (stu_leader_id) REFERENCES T_student(stu_id),
  FOREIGN KEY (stu_team) REFERENCES T_team(t_id)
);
CREATE TABLE T_stuleve1(
  lid int AUTO_INCREMENT,
  llow FLOAT,
  lhight FLOAT
);


SELECT DISTINCT *  FROM `1509a.student`;
DROP TABLE for_a;    -- 删除表
CREATE TABLE for_a(
  a_id int AUTO_INCREMENT UNIQUE ,
  a_name VARCHAR(30) UNIQUE ,
  b_id INT NOT NULL ,
  b_name VARCHAR(30),
  FOREIGN KEY(b_id) REFERENCES for_a(a_id),      -- for_a.a_id是主键或唯一的
  FOREIGN KEY(b_name) REFERENCES for_a(a_name)
#   FOREIGN KEY(b_name) REFERENCES for_a(a_name)
);
DROP TABLE chat.user_feiend;
/*
创建一个表记录中多个外键指向同一字段
 */
CREATE TABLE chat.user_feiend (
  `user_id` int(11) NOT NULL  ,
  user_name VARCHAR(30) NOT NULL ,
  `friend_id` int(11) NOT NULL  ,
  `friend_name` varchar(30) NOT NULL  ,
  `friend_date` date DEFAULT NULL,
  FOREIGN KEY(user_id) REFERENCES chat.char_user(user_id),
  FOREIGN KEY(user_name) REFERENCES chat.char_user(user_name),
  FOREIGN KEY(friend_id) REFERENCES chat.char_user(user_id),
  FOREIGN KEY(friend_name) REFERENCES chat.char_user(user_name)
);
DROP TABLE chat.char_user;
CREATE TABLE chat.char_user (
  `user_id` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `user_passwd` varchar(30) NOT NULL,
  `user_name` varchar(10) NOT NULL UNIQUE ,
  `user_status` tinyint(1) DEFAULT '0',
  `user_ip` varchar(15) DEFAULT NULL,
  `user_port` char(4) DEFAULT '8888',
  `user_message` blob,
  `user_InetAddress` blob,
  `user_omessage` blob,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
  SELECT * FROM student where id between 1 and 5;
  SELECT * FROM student  where SEX in (0,1);
  SELECT * FROM student  where SNO LIKE '%a%';
  SELECT * FROM student  where SNO LIKE '_i%';
INSERT INTO chat.user_feiend (user_id, user_name, friend_id, friend_name, friend_date) VALUES (1,'88',3,'1','2015-12-11');
SELECT * FROM test.class ORDER BY c_name  ;
INSERT INTO test.class(c_name,c_name2) VALUES ('ff','sz');
SELECT * FROM test.class ORDER BY c_name DESC ,c_name2 ;

