package com.beicai.wissy.test;

import com.beicai.wissy.MyException.DataOutOfBoundException;
import com.beicai.wissy.entity.Commodity;
import com.beicai.wissy.entity.Member;
import com.beicai.wissy.entity.MemberShoppingManagement;
import com.beicai.wissy.service.CommodityManagement;

import java.util.ArrayList;

/**
 * Created by wissy on 2015/11/18.
 */
public class test {
    public static void main(String[] args) throws DataOutOfBoundException {
        Member member = new Member();
        MemberShoppingManagement aa=member.getMsm();
        aa.initial();
        aa.getComoditiesList();
        aa.addCommodityOfMyMem(new Commodity(25,"kk",55,true));
        System.out.println(aa.getTotal());

    }
}
