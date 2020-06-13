package com.queue;

public class ArrayQueue {
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部前一个位置
        rear=-1;
    }
    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空不能取数据");
        }
        front++;
        return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，不能遍历");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
