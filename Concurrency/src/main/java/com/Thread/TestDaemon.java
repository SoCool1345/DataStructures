package com.Thread;
//测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();
        Thread thread=new Thread(god);
        thread.setDaemon(true);//true为守护进程
        thread.start();
        new Thread(you).start();
    }


}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("god守护着你");
        }

    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("happy");
        }
        System.out.println("goodbye");
        }
}

