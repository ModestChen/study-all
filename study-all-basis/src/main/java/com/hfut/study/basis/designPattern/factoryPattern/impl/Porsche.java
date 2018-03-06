package com.hfut.study.basis.designPattern.factoryPattern.impl;

import com.hfut.study.basis.designPattern.factoryPattern.Car;

/**
 * @author chenjia
 * @create 2017-11-14 15:27
 * @desc 兰博基尼
 **/
public class Porsche implements Car {

    @Override
    public String getCar() {
        return "保时捷";
    }
}
