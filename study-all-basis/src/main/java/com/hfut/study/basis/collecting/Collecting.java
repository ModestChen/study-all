package com.hfut.study.basis.collecting;

import java.util.*;

/**
 * @author chenjia
 * @create 2017-10-25 22:29
 * @desc 集合类
 **/
public class Collecting {
    public static void main(String args[]) {
//        mapTest();

        listTest();
    }

    /**
     * list测试
     */
    private static void listTest() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("1");
        stringList.add("2");
//        for (String string : stringList) {
//            System.out.println(string);
//        }
        Iterator iterable=stringList.iterator();
        for (;iterable.hasNext();){
            System.out.println(iterable.next());
        }
    }

    /**
     * Map测试
     */
    private static void mapTest() {

        Hashtable h = new Hashtable();

        h.put("用户1", new Integer(90));

        h.put("用户2", new Integer(50));

        h.put("用户3", new Integer(60));

        h.put("用户4", new Integer(70));

        h.put("用户5", new Integer(80));

        Enumeration e = h.elements();

        while (e.hasMoreElements()) {

            System.out.println(e.nextElement());
        }
    }
}
