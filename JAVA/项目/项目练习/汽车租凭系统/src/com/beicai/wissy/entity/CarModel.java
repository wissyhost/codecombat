package com.beicai.wissy.entity;


/**
 * Created by wissy on 2015/11/16.
 * 型号
 */
public class CarModel {
    private int price;
    private String name;
    private String CarBrandNumber;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarBrandNumber() {
        return CarBrandNumber;
    }

    public void setCarBrandNumber(String carBrandNumber) {
        CarBrandNumber = carBrandNumber;
    }

    public CarModel() {
        super();
    }

    public CarModel(int price, String name, String carBrandNumber) {
        super();
        this.price = price;
        this.name = name;
        CarBrandNumber = carBrandNumber;
    }

}