package com.beicai.wissy.view;

import java.util.Scanner;
import com.beicai.wissy.entity.*;
import com.beicai.wissy.service.CarService;
import com.beicai.wissy.tools.getInfo;

/**
 * Created by wissy on 2015/11/16.
 */

public class CarView {
    getInfo info = new getInfo();
    //	CarEntity car=new CarEntity(500, "550i", "京C8888", "宝马", "轿车");
    CarEntity car = new CarEntity(0, "", "", "", "");
    //CarEntity car1=new CarEntity(price, setName, setCarBrandNumber, setBrandName, setTypeName)
    private CarService service = new CarService();

    public CarView() {
        showCarView();
    }

    public void showCarView() {
        Scanner input = new Scanner(System.in);
        int days = 0;
        System.out.println("欢迎您来到汽车租凭公司");
        System.out.println("请输入要租凭的天数:");
        days = input.nextInt();
        System.out.println("请输入汽车类型(1.轿车  2.客车)");
        int m1 = input.nextInt();
        switch (m1) {// 轿车
            case 1:
                info.setTypeName(car, "轿车");
                System.out.println("请输入汽车品牌(1.宝马  2.别克)");
                int m2 = input.nextInt();
                switch (m2) {
                    case 1:
                        info.setBrandName(car, "宝马");
                        System.out.println("请输入汽车型号(1.550i)");
                        int m3 = input.nextInt();
                        switch (m3) {
                            case 1:
                                info.setName(car, "550i");
                                break;
                        }
                        break;
                    case 2:
                        info.setBrandName(car, "别克");
                        System.out.println("请输入汽车型号(1.商务舱GL8 2.林荫大道)");
                        int m31 = input.nextInt();
                        switch (m31) {
                            case 1:
                                info.setName(car, "商务舱GL8");
                                break;
                            case 2:
                                info.setName(car, "林荫大道");
                                break;
                        }
                        break;
                }
                break;
            case 2:// 客车
                info.setTypeName(car, "客车");
                System.out.println("请输入客车品牌(1.金杯  2.金龙)");
                int m21 = input.nextInt();
                switch (m21) {
                    case 1:
                        info.setBrandName(car, "金杯");
                        break;
                    case 2:
                        info.setBrandName(car, "金龙");
                        break;
                }
                System.out.println("请输入客车的座位数:");
                int zuo = input.nextInt();
                info.setName(car, (zuo >= 16 ? ">16" : "<=16"));
                break;
        }

        //拼装
        service.carRental(car, days);
        System.out.println("您分配的车牌是:" + car.getCarType().getCarbrand().getBrand().getCarBrandNumber());
        System.out.println("");
        System.out.println("顾客您好,您需要支付的租凭费用为:" + car.getTotalMoney());
        //-------------------------
        System.out.println("");
        /**
         * 控制台输出 控制台输入(收集客户信息) int f= service.scarjjjj(car,Day) 控制台输出(租借金额,车牌号)
         */
    }

    // public static void main(String[] args) {
    //
    // }

}
