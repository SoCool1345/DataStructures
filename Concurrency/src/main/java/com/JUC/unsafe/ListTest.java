package com.JUC.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    //ConcurrentModificationException并发修改异常
    public static void main(String[] args) {
        //ArrayList在并发下不安全
        /**
         * 用new Vector<>()解决
         * Collections.synchronizedList(new ArrayList<>())
         * new CopyOnWriteArrayList<>()写入时复制
         */
        List<String> list= new CopyOnWriteArrayList<>();
        Map<String,String> map=new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
        list.forEach(System.out::println);
    }
}
