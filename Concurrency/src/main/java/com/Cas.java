package com;

import java.util.concurrent.atomic.AtomicInteger;

public class Cas {
    public static void main(String[] args) {
        AtomicInteger integer=new AtomicInteger(2000);
        integer.compareAndSet(2000,2002);
        System.out.println(integer.get());
        
    }

}

