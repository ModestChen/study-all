package com.hfut.study.basis.thread;

/**
 * @author chenjia
 * @create 2017-10-22 15:11
 * @desc 线程同步与互斥
 * 问题：子线程循环10次，接着主线程循环20次，如此交替执行循环50次
 **/
public class ThreadSynchronized {
   static class Operation {
        private boolean flag = true;

        public synchronized void sub(int i) {
            while (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("sub Thread run " + j + " all " + i);
            }
            flag = false;
            this.notify();
        }

        public synchronized void main(int i) {
            while (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 20; j++) {
                System.out.println("main Thread run " + j + " all " + i);
            }
            flag = true;
            this.notify();
        }
    }
    public static void main(String[] args) {
        final Operation operation = new Operation();
        /*子线程*/
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    operation.sub(i);
                }
            }
        }).start();
        /*主线程*/

        for (int i = 0; i < 50; i++) {
            operation.main(i);
        }
    }
}

