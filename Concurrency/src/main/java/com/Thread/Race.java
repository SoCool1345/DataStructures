package com.Thread;

public class Race implements Runnable {
    private static String  winner;
    @Override
    public void run() {
        int end=100;
        for (int i = 0; i <= end; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
            if (gameOver(i,end)){
                break;
            }
        }
    }
    public boolean gameOver(int step,int end){
        if(winner!=null){
            return true;
        }else {
            if (step==end){
                winner=Thread.currentThread().getName();
                System.out.println("winner is"+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race1=new Race();
        new Thread(race1,"兔子").start();
        new Thread(race1,"乌龟").start();
    }
}
