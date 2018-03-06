package com.hfut.study.basis.designPattern.observerPattern.myObserver;

/**
 * @author chenjia
 * @create 2017-11-16 16:38
 * @desc 观察者
 **/
public interface Observer {
    /**
     * 从目标处的发现
     */
    void tellFound(Subject subject);
}
