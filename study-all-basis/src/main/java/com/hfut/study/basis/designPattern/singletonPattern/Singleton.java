package com.hfut.study.basis.designPattern.singletonPattern;

/**
 * @author chenjia
 * @create 2017-11-14 14:39
 * @desc 单例模式
 **/
public class Singleton {
    public static void main(String[] args) {
        System.out.println(Demo.getSingleton().getName());

    }

    static class Demo {

        private Demo(String name) {
            this.setName(name);
        }

    /*饿汉模式*/
/*    private final static Demo demo = new Demo("陈佳");

    public  static Demo getSingleton() {
        return demo;
    }*/

        /*懒汉模式*/
        private static Demo demo = null;

        public synchronized static Demo getSingleton() {
            if (demo == null) {
                return new Demo("陈佳");
            }
            return demo;
        }

        private String name;

        public Demo getDemo() {
            return demo;
        }

        public void setDemo(Demo demo) {
            this.demo = demo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

