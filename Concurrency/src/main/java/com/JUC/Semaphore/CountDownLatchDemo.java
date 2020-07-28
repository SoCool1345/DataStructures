package com.JUC.Semaphore;

import java.util.concurrent.CountDownLatch;

//减法计数器
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch=new CountDownLatch(6);//倒计时
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后在向下执行
        System.out.println("close door");
    }
}
