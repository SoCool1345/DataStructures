package com.single;

public class LazyMan {
    //单线程下有效
    private LazyMan(){}
    private volatile static LazyMan LazyMan;//避免指令重排
    public static LazyMan getInstance(){
        //加锁，保证多线程有效
        if(LazyMan==null){
            synchronized (LazyMan.class){
                if(LazyMan==null){
                    LazyMan=new LazyMan();//不是原子性操作
                }
            }
        }

        return LazyMan;
    }
}
