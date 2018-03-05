package com.hfut.study.basis.designPattern.observerPattern.myObserver.impl.observer;

import com.hfut.study.basis.designPattern.observerPattern.myObserver.Observer;
import com.hfut.study.basis.designPattern.observerPattern.myObserver.Subject;

/**
 * @author chenjia
 * @create 2017-11-16 16:57
 * @desc 观察者陈佳
 **/
public class CJObserver implements Observer {
    private String name;

    public CJObserver(String name) {
        this.name = name;
    }

    @Override
    public void tellFound(Subject subject) {
        System.out.println(subject.getContent());
    }
}
