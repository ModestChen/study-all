package com.hfut.study.basis.designPattern.factoryPattern;

import com.hfut.study.common.util.ReadAppliactionUtils;

import java.util.Map;

/**
 * @author chenjia
 * @create 2017-11-14 15:29
 * @desc 车工厂
 **/
public class CarFactory {
    public String getCar(String carName) {
        try {
            Map<String, String> carFactoryMap = new ReadAppliactionUtils().readProperties("/carFactory.properties");
            Car car = (Car) Class.forName(carFactoryMap.get(carName)).newInstance();
            return car.getCar();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//        if ("lamBorghini".equals(carName)) {
//            return new LamBorghini().getCar();
//        }
//        if ("porsche".equals(carName)) {
//            return new Porsche().getCar();
//        }
        return null;
    }
}
