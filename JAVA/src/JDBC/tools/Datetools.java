package JDBC.tools;




/**
 * Created by wissy on 2015/12/17.
 */
public class Datetools {
    public static java.sql.Date DateChange( java.util.Date date){
        if (date==null)
            return null;
        return new java.sql.Date(date.getTime());
    }
    public static  java.util.Date DateChange( java.sql.Date date){
        if (date==null)
            return null;
        return new java.util.Date(date.getTime());
    }
}
