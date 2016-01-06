package com.beicai.wissy.entity;

/**
 * Created by wissy on 2015/11/16.
 */
public class CarEntity {
    private CarType carType;
    private int totalMoney;

//
//	public CarEntity() {
//		super();
//	}

    public CarEntity(int price, String setName, String setCarBrandNumber, String setBrandName, String setTypeName) {
        super();
        CarModel model = new CarModel(price, setName, setCarBrandNumber);
        CarBrand brand = new CarBrand(setBrandName, model);
        CarType type = new CarType(setTypeName, brand);
        setCarType(type);
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }


    public CarType getCarType() {
        return carType;
    }

    private void setCarType(CarType carType) {
        this.carType = carType;
    }

}

