package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueue {
    public static void main(String[] args) throws Exception{
        ArrayBlockingQueue blockQueue=new ArrayBlockingQueue<>(3);
        System.out.println( blockQueue.offer("a"));
        System.out.println(blockQueue.offer("a"));
        System.out.println(blockQueue.offer("a"));
        System.out.println( blockQueue.offer("a",3, TimeUnit.SECONDS));
        System.out.println(blockQueue.take());
        System.out.println(blockQueue.take());
        System.out.println(blockQueue.take());
        System.out.println(blockQueue.poll(2,TimeUnit.SECONDS));
    }
}
