package com.Thread;
//模拟网络延时
public class TestSleep implements Runnable{
    private int ticketNums=10;
    boolean flag=true;
    @Override
    public void run() {
        while (flag){

            try {
                buy();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    public synchronized void buy()throws InterruptedException{
        if (ticketNums<=0){
            flag=false;
            return;
        }
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"票");
    }

    public static void main(String[] args) {
        TestSleep testSleep=new TestSleep();
        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"老师").start();
        new Thread(testSleep,"黄牛").start();
    }
}
