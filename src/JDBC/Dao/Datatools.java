package JDBC.Dao;

import java.util.Date;

/**
 * Created by wissy on 2015/12/17.
 */
public class Datatools {
    public static Date DateChange(java.sql.Date sqlDate){
        Date date=new Date(sqlDate.getTime());
        return date;
    }

    public static void main(String[] args) {
        java.sql.Date a=new java.sql.Date(System.currentTimeMillis());
        System.out.println(DateChange(a));
    }
}
