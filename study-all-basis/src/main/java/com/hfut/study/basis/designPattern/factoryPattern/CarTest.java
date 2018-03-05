package com.hfut.study.basis.designPattern.factoryPattern;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author chenjia
 * @create 2017-11-14 15:33
 * @desc 测试类
 **/
public class CarTest {
    @Value("${girl.cupSize}")
    private String cupSize;

    public static void main(String[] args) {
//        CarFactory carFactory = new CarFactory();
        CarFactory carFactory= null;
        try {
            carFactory = CarFactory.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(carFactory.getCar("Porsche"));

    }
}
