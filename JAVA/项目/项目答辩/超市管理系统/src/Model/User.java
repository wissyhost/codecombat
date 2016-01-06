package Model;

/**
 * Created by wissy on 2015/12/7.
 */
public class User {
    //编号,用户名,密码,邮箱,生日,地址,性别,手机,年龄
    private int user_id;
    private String user_name;
    private String user_passwd;
    private String user_email;
    private String user_birthday;
    private String user_user_address;
    private int user_sex;
    private int user_mobile;
    private int user_age;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_user_address() {
        return user_user_address;
    }

    public void setUser_user_address(String user_user_address) {
        this.user_user_address = user_user_address;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(int user_mobile) {
        this.user_mobile = user_mobile;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }
}
