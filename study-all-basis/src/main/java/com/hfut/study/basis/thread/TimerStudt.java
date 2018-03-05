package com.hfut.study.basis.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenjia
 * @create 2017-10-22 12:39
 * @desc 定时器学习---实现两秒和四秒交替爆炸
 * 注意：quartz 可以解决周期定时的功能
 **/
public class TimerStudt {
    private static int time;

    public static void main(String[] args) {

        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                time++;
                System.out.println("bombing...");
                new Timer().schedule(new MyTimerTask(), 2000 + 1000 * (time % 2));
            }
        }
        new Timer().schedule(new MyTimerTask(), 2000);
        for (; ; ) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
