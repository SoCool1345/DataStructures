package com.Thread;

import java.util.concurrent.*;

public class Call implements Callable<Boolean> {
    private static String  winner;
    @Override
    public Boolean call() {
        int end=100;
        for (int i = 0; i <= end; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
            if (gameOver(i,end)){
                return true;
            }
        }
        return false;
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

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        Call c1=new Call();
        Call c2=new Call();
        ExecutorService service= Executors.newFixedThreadPool(2);
        Future<Boolean> r1=service.submit(c1);
        Future<Boolean> r2=service.submit(c2);

        boolean rs1=r1.get();
        boolean rs2=r2.get();
        System.out.println(rs1+" "+rs2);
        service.shutdownNow();
    }
}
