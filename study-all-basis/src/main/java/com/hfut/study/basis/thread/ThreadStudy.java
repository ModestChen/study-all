package com.hfut.study.basis.thread;

/**
 * @author chenjia
 * @create 2017-10-22 12:01
 * @desc 线程学习-----线程实现的两种方法：1.在Thread的子类中重新Thread的run方法；2.传递Runnable对象重写run方法
 **/
public class ThreadStudy {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("runnble");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) {
            public void run() {
                try {
                    System.out.println("本地");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
