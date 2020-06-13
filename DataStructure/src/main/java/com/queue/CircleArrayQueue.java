package com.queue;

public class CircleArrayQueue {
    private int maxSize;
    private int front;//队列头,初始值为0
    private int rear;//队列尾，初始值为0
    private int[] arr;//该数组用于存放数据

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
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
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空不能取数据");
        }
        int temp=arr[front];
        front=(front+1)%maxSize;
        return temp;
    }
    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，不能遍历");
        }
        for (int i = front; i <front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //求出当前队列有效值的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
