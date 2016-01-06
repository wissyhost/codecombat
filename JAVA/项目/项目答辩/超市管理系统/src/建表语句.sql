/*
用户信息表
*/
CREATE TABLE wys_shop.s_employee (
`employee_No`  varchar(20) PRIMARY KEY COMMENT 'ID' ,
`employee_Name`  varchar(20) NULL COMMENT '姓名' ,
`employee_Passwd`  varchar(30) NULL COMMENT '密码' ,
`employee_Sex`  char(2) NULL COMMENT '性别' ,
`employee_Birthday`  date NULL COMMENT '生日' ,
`employee_EducationId`  int NULL COMMENT '学历' ,
`employee_HomeTel`  varchar(20) NULL COMMENT '家庭电话' ,
`employee_Mobile`  varchar(20) NULL COMMENT '手机号' ,
`employee_Card`  varchar(20) NULL COMMENT '身份证号' ,
`employee_Email`  varchar(30) NULL COMMENT '电子邮箱' ,
`employee_Address`  varchar(80) NOT NULL COMMENT '家庭住址'
);
/*
学历信息表
*/
CREATE TABLE s_edu (
  `educationId`  int NOT NULL COMMENT '学历编号' ,
  `educationName`  varchar(20) NOT NULL COMMENT '学历名称'
);
/*
管理员信息表
*/
CREATE TABLE wys_shop.s_admin (
  `adminUsername`  varchar(20) NOT NULL ,
  `adminPasswd`  varchar(32) NOT NULL
);

/*
员工业绩表
*/
CREATE TABLE wys_shop.s_sell (
  `employeeNo`  varchar(20) NOT NULL COMMENT '员工编号' ,
  `employeeName`  varchar(8) NOT NULL COMMENT '员工名称' ,
  `employeeSellMoney`  FLOAT NOT NULL COMMENT '销售金额'
COMMENT '员工业绩表'
);
/*
进货登记表
*/
CREATE TABLE wys_shop.s_buy (
  `buyId`  int NOT NULL COMMENT '进货单号' ,
  `goodNo`  varchar(20) NOT NULL COMMENT '商品编号' ,
  `supplierName`  varchar(50) NOT NULL COMMENT '供应商' ,
  `price`  float(10,2) NULL COMMENT '进货价格' ,
  `number`  int NULL COMMENT '进货数量' ,
  `totalPrice`  float(10,2) NULL COMMENT '进货总价' ,
  `buyDate`  datetime NULL COMMENT '进货日期' ,
  `addTime`  datetime NULL COMMENT '登记时间'
  COMMENT '进货登记表'
);
/*
供应商信息表
 */
CREATE TABLE `wys_shop.s_supplier` (
  `supplier_Name` varchar(50) NOT NULL COMMENT '公司名称',
  `supplier_Lawyer` varchar(4) DEFAULT NULL COMMENT '法人代表',
  `supplier_Telephone` varchar(11) NOT NULL COMMENT '电话',
  `supplier_Address` varchar(50) DEFAULT NULL COMMENT '供应商地址'
  COMMENT '供货商信息表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/*
商品信息表
*/
CREATE TABLE wys_shop.s_good (
  `good_No`  varchar(20) NOT NULL COMMENT '商品编号' ,
  `good_ClassId`  int NULL DEFAULT '类型编号' ,
  `good_Name`  varchar(30) NOT NULL COMMENT '商品名称' ,
  `good_Unit`  varchar(2) NULL COMMENT '商品单位' ,
  `good_Model`  varchar(20) NULL COMMENT '商品型号' ,
  `good_Specs`  varchar(20) NULL DEFAULT '商品规格' ,
  `good_Price`  float(10,2) NULL DEFAULT '商品售价 ',
  `good_Place`  varchar(50) NULL COMMENT '商品产地' ,
  `good_Memo`  char(10) NULL COMMENT '备注信息' ,
  `good_AddTime`  datetime NULL COMMENT '进货信息' ,
  PRIMARY KEY (`good_No`)
)
  COMMENT='商品信息表'
;
/*
退货登记表
 */
CREATE TABLE wys_shop.buyBack (
  `buyBackId`  int NOT NULL COMMENT '退货编号' ,
  `goodNo`  varchar(20) NULL COMMENT '商品编号' ,
  `supplierName`  varchar(50) NULL COMMENT '供应商' ,
  `price`  float(10,2) NULL COMMENT '退货价格' ,
  `number`  int NULL COMMENT '退货数量' ,
  `toatlPrice`  float(10,2) NULL COMMENT '退货总价' ,
  `buyBackDate`  datetime NULL COMMENT '退货日期' ,
  `buyBackReason`  text NULL COMMENT '退货原因' ,
  `buyBackAddTime`  datetime NULL COMMENT '登记时间'
  COMMENT '退货登记表'
);





