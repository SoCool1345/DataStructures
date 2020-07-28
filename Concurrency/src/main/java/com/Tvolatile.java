package com;

import java.util.concurrent.atomic.AtomicInteger;

public class Tvolatile {
    class A{
       public void t(){}
       public void c(){

       }
    }
    private static AtomicInteger num=new AtomicInteger();
    public  static void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {
        Tvolatile tvolatile=new Tvolatile();
        Tvolatile.A a=tvolatile.new A();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
