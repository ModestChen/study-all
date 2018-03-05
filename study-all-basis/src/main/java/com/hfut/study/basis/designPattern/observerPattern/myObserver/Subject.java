package com.hfut.study.basis.designPattern.observerPattern.myObserver;

/**
 * @author chenjia
 * @create 2017-11-16 16:37
 * @desc 目标
 **/
public interface Subject {
    /**
     * 增加观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     */
    void delObserver(Observer observer);


    String getContent();

    void setContent(String content);

    /**
     * 通知观察者
     */
    void callObserver();

}
