package com.Thread.syn;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable{
    int ticketnums=10;
    //定义lock
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){

            try {
                lock.lock();
                if (ticketnums>0){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(ticketnums--);
                }else break;
            }finally {

                lock.unlock();
            }

        }
    }
}
