package JDBC.jdbc;

import JDBC.dao.表名Dao;
import JDBC.entity.ClassEntity;
import JDBC.tools.PropertiesTools;

import java.util.List;

/**
 * Created by wissy on 2015/12/17.
 */

/**
 * 测试类
 */
public class test {
    public static void main(String[] args) {
        表名Dao temp = new 表名Dao();
        boolean b = temp.execUpdate(PropertiesTools.getSqlMessage("class.exec"));//插入记录
        System.out.println(b);
        List<ClassEntity> list=temp.query(PropertiesTools.getSqlMessage("class.query"));//查询语句
        for (ClassEntity a : list) {
            System.out.print(a.getcId()+"\t");
            System.out.print(a.getCName()+"\t");
            System.out.println(a.getCName2());
        }
    }


}
