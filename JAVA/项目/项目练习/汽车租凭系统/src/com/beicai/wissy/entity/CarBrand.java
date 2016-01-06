package com.beicai.wissy.entity;

/**
 * Created by wissy on 2015/11/16.
 * 品牌
 */
public class CarBrand {
    private String BrandName;
    private CarModel brand;// = new CarModel();

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String string) {
        BrandName = string;
    }

    public CarBrand() {
        super();
    }

    public CarBrand(String brandName, CarModel brand) {
        super();
        BrandName = brandName;
        this.brand = brand;
    }

    public CarModel getBrand() {
        return brand;
    }

    public void setBrand(CarModel brand) {
        this.brand = brand;
    }

}

