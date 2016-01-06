package com.beicai.wissy.entity;

/**
 * Created by wissy on 2015/11/18.
 */

import com.beicai.wissy.MyException.DataOutOfBoundException;

import java.io.DataOutputStream;

/**
 * 商品
 */
public class Commodity{
    private String CommodityName;
    private int CommodityNumber;
    private float CommodityPrice;
    private boolean CommdityState;

    @Override
    public String toString() {
       return "商品名称 "+getCommodityName()+"价格 "+getCommodityPrice()+"状态 "
               + (((isCommdityState())&&(0<getCommodityNumber()))?"可以购买":"不可以购买")+"  数量 "+getCommodityNumber();
    }

    public Commodity() {
    }

    public Commodity(int commodityNumber, String commodityName, float commodityPrice, boolean commdityState)
            throws DataOutOfBoundException {
       setCommdityState(commdityState);
        setCommodityName(commodityName);
        setCommodityNumber(commodityNumber);
        setCommodityPrice(commodityPrice);

    }

    public boolean isCommdityState() {
        return CommdityState;
    }

    public void setCommdityState(boolean commdityState) {
        CommdityState = commdityState;
    }

    public String getCommodityName() {
        return CommodityName;
    }

    public void setCommodityName(String commodityName) {
        CommodityName = commodityName;
    }

    public int getCommodityNumber() {
        return CommodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) throws DataOutOfBoundException{
        if(commodityNumber<0){
            throw new DataOutOfBoundException("数量");
        }else{
            CommodityNumber = commodityNumber;
        }
    }

    public float getCommodityPrice() {
        return CommodityPrice;
    }

    public void setCommodityPrice(float commodityPrivate) throws DataOutOfBoundException{
        if(commodityPrivate<0){
            throw new DataOutOfBoundException("价格");
        }else{
            CommodityPrice = commodityPrivate;
        }

    }


}
