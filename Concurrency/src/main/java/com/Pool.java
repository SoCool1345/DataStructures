package com;

import java.util.concurrent.*;
//三大方法，7大参数，4种拒绝策略
public class Pool {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,Runtime.getRuntime().availableProcessors(),3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor .DiscardOldestPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
