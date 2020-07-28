package com;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABA {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> integer=new AtomicStampedReference<>(2000,1);
    }
}
