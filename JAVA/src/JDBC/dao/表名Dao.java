package JDBC.dao;

/**
 * Created by wissy on 2015/12/17.
 */

import JDBC.entity.ClassEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 表名为数据库实际执行的表名 如:StudentDao
 * 对student表的增删改查
 */
public class 表名Dao extends DaoSupport {
    /**
     * 提供DML操作方法
     */
    public boolean execUpdate(String sql){
        boolean ret=false;
        this.ConnectionDB();
        try {
            stmt=conn.createStatement();
            int n=stmt.executeUpdate(sql);
            if (n>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }

        return ret;
    }
    /**
     * 提供DQL功能
     * 警告!!不能返回ResultSet,ResultSet在数据库关闭后会为null
     * 这样数据库就关闭不了
     * 正确的返回方法:返回一个实体类集合,实体类内装满数据
     * 推荐LIst<表名Entity>,有下标,方便遍历
     */
    public List<ClassEntity> query(String sql){
        List<ClassEntity> ret = new ArrayList<ClassEntity>();
        this.ConnectionDB();
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                /**
                 * 把表中行记录放在实体类对象里面
                 */
            ClassEntity temp=new ClassEntity();//定义一个零时变量
                temp.setcId(rs.getInt("c_id"));
                temp.setCName(rs.getString("c_name"));
                temp.setCName2(rs.getString("c_name2"));
                //一行记录一个对象
                ret.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }

        return  ret;
    }
}
