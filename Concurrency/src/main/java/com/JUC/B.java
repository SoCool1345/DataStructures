package com.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock
 */
public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"D").start();
    }

}

/**
 * 判断等待，业务，通知
 */
class Data2 {
    private int number = 0;
    Lock lock = new ReentrantLock();
    //可以精准唤醒
    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "->" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //防止虚假唤醒
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "->" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
