package com.single;

public class Hungry {
    //浪费空间
    private Hungry(){}
    private final static Hungry HUNGRY=new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;
    }
}
