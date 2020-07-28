package com.JUC.rwLock;

import java.util.*;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //写入
        for (int i = 1; i <= 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            }).start();
        }
        //读取
        for (int i = 1; i <= 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            }).start();
        }
    }
}

/**
 * 自定义缓存
 */
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入成功");
    }
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o=map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取成功");
    }
}