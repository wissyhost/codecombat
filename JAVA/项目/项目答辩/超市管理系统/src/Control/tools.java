package Control;


import Model.DBUtil;
import Model.User;

import java.sql.PreparedStatement;

/**
 * Created by wissy on 2015/12/15.
 */
public class tools {
  public void userToDB(){
      String sql="";

      PreparedStatement connection = DBUtil.getConnection(sql);
  }
    public User DBToUser(){
        return null;
    }
    public void userUpdate(){

    }

}
