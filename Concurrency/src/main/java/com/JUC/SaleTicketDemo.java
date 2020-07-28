package com.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); }).start();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); }).start();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); }).start();
    }
}
//资源类
class Ticket{
    private int number=40;
    Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"剩余"+number);
            }
        }finally {
            lock.unlock();
        }

    }
}