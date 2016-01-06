package com.beicai.wissy.entity;


/**
 * Created by wissy on 2015/11/16.
 * 类型
 */

public class CarType {
    private String typeName;
    private CarBrand carBrand;

    public CarType(String typeName, CarBrand carBrand) {
        super();
        this.typeName = typeName;
        this.carBrand = carBrand;
    }

    public CarType() {
        super();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public CarBrand getCarbrand() {
        return carBrand;
    }

    public void setCarbrand(CarBrand carbrand) {
        this.carBrand = carbrand;
    }

}
