package com.beicai.wissy.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.beicai.wissy.entity.*;
import com.beicai.wissy.tools.getInfo;



/**
 * Created by wissy on 2015/11/16.
 */

/**
 * 1.封装数据并且组合数据,将数据按块分级,依次组装
 * 2.初始化数据
 * 3.对服务层进行数据运算,利用少量的数据判断运算,得出结果
 * @author wissy
 *
 */
public class CarService {
    // 车的集合
    List<CarEntity> list = new ArrayList<CarEntity>();

    public CarService() {
        initial();// 在构造器中形成车型
    }
    // 初始化车型
//CarEntity kk= new CarEntity(price, setName, setCarBrandNumber, setBrandName, setTypeName)
    private void initial() {//不允许外部初始化,只能在构造器中进行
        list.add(new CarEntity(600, "商旅GL8", "京A8888", "别克", "轿车"));
        list.add(new CarEntity(300, "林荫大道", "京B8888", "别克", "轿车"));
        list.add(new CarEntity(500, "550i", "京C8888", "宝马", "轿车"));
        list.add(new CarEntity(800, "<=16", "京D8888", "金杯", "客车"));
        list.add(new CarEntity(1500, ">16", "京E8888", "金杯", "客车"));
        list.add(new CarEntity(800, "<=16", "京F8888", "金龙", "客车"));
        list.add(new CarEntity(1500, ">16", "京G8888", "金龙", "客车"));
    }

    // 租车服务
    public CarEntity carRental(CarEntity sendCarEntity, int day) {
        getInfo info = new getInfo();
        int i=0;
        Iterator<CarEntity> it = list.iterator();// 获取迭代
        while (it.hasNext()) {
            CarEntity carTemp = it.next();
            if (info.getCarBrandName(carTemp).equals(
                    info.getCarBrandName(sendCarEntity))//品牌
                    && info.getCarModelName(carTemp).equals(
                    info.getCarModelName(sendCarEntity))//车型
                    && info.getCarType(carTemp).equals(
                    info.getCarType(sendCarEntity))) {//车类型
                sendCarEntity.setTotalMoney(info.getCarModelprice(carTemp)*day);// 取出所租车的金额并计算
                sendCarEntity.getCarType().getCarbrand().getBrand()
                        .setCarBrandNumber(info.getCarBrandNumber(carTemp));//获取车牌号并且写入当前车
                break;// 跳出循环,提高效率
            }
        }
        return sendCarEntity;
    }

//	public static void main(String[] args) {
//		CarService carList = new CarService();
//		// carList.init();
//		Iterator<CarEntity> it = carList.list.iterator();
//		while (it.hasNext()) {
//			CarEntity temp = it.next();
//			System.out.println(temp.getCarType().getTypeName());
//		}
//		CarEntity a = new CarEntity(500, "550i", "550", "宝马", "轿车");
//		System.out.println(carList.carRental(a, 25).getTotalMoney());
//
//	}
}
