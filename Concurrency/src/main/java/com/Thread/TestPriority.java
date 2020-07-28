package com.Thread;
//测试线程优先级
public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
        MyPriority myPriority=new MyPriority();
        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}
