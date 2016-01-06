package com.beicai.wissy.entity;

/**
 * Created by wissy on 2015/11/18.
 */

import com.beicai.wissy.MyException.DataOutOfBoundException;

/**
 * 会员
 */
public class Member {
    private String MemberName;
    private int MemberAge;
    private Boolean MemberSex;
    //购物车
   private MemberShoppingManagement msm = new MemberShoppingManagement();

    public MemberShoppingManagement getMsm() {
        return msm;
    }
    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public int getMemberAge() {

        return MemberAge;
    }

    public void setMemberAge(int memberAge) throws DataOutOfBoundException{
        if(memberAge<0){
            throw new DataOutOfBoundException("价格");
        }else{
            MemberAge = memberAge;
        }
    }

    public Boolean getMemberSex() {
        return MemberSex;
    }

    public void setMemberSex(Boolean memberSex) {
        MemberSex = memberSex;
    }
}
