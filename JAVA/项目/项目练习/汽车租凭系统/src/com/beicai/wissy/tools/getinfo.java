package com.beicai.wissy.tools;

import com.beicai.wissy.entity.*;
/**
 * Created by wissy on 2015/11/16.
 */
public class getInfo {
    public void change(int m, boolean n) {
        if (m == 1) {
            n = true;
        } else if (m == 2) {
            n = false;
        } else {
            System.out.println("参数不正确");
        }
    }

    public String getCarType(CarEntity carEntity) {
        return carEntity.getCarType().getTypeName();
    }

    public String getCarBrandNumber(CarEntity carEntity) {
        return carEntity.getCarType().getCarbrand().getBrand().getCarBrandNumber();
    }

    public String getCarBrandName(CarEntity carEntity) {
        return carEntity.getCarType().getCarbrand().getBrandName();
    }

    public String getCarModelName(CarEntity carEntity) {
        return carEntity.getCarType().getCarbrand().getBrand().getName();
    }

    public int getCarModelprice(CarEntity carEntity) {
        return carEntity.getCarType().getCarbrand().getBrand().getPrice();
    }

    //---------------
    public void setTypeName(CarEntity carEntity, String typeName) {
        carEntity.getCarType().setTypeName(typeName);
    }

    //	public void setModelName(CarEntity carEntity,String name) {
//		carEntity.getCarType().getCarbrand().getBrand().setName(name);
//	}
    public void setBrandName(CarEntity carEntity, String brandName) {
        carEntity.getCarType().getCarbrand().setBrandName(brandName);
    }

    public void setName(CarEntity carEntity, String name) {
        carEntity.getCarType().getCarbrand().getBrand().setName(name);
    }

    public void setPrice(CarEntity carEntity, int price) {
        carEntity.getCarType().getCarbrand().getBrand().setPrice(price);
    }

}
