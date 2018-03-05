package com.hfut.study.basis.designPattern.observerPattern.myObserver.impl.subject;

import com.hfut.study.basis.designPattern.observerPattern.myObserver.Observer;
import com.hfut.study.basis.designPattern.observerPattern.myObserver.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjia
 * @create 2017-11-16 16:48
 * @desc 具体的目标
 **/
public class concreteSubject implements Subject {
    private List<Observer> observerList = new ArrayList<Observer>();
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void callObserver() {
        for (Observer observer : observerList) {
            observer.tellFound(this);
        }
    }
}
