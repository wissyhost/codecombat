package JDBC.entity;

/**
 * Created by wissy on 2015/12/17.
 */

import JDBC.tools.Datetools;

import java.util.Date;

/**
 * 用包装类
 * int不能接受null
 * Integer可以接受null
 */
public class ClassEntity {
    private Integer cId;
    private String CName;
    private String CName2;
    private Date CDate;

    public Date getCDate() {
        return CDate;
    }

    public void setCDate(Date CDate) {
        this.CDate = CDate;
    }
    public void setCDate(java.sql.Date CDate) {
        this.CDate = Datetools.DateChange(CDate);
    }
    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCName2() {
        return CName2;
    }

    public void setCName2(String CName2) {
        this.CName2 = CName2;
    }
}
