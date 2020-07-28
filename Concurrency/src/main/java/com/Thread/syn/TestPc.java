package com.Thread.syn;
//测试生产者消费者模型-->利用缓冲区解决：管程法

public class TestPc {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Product(i));
            System.out.println("生产了"+i+"个产品");
        }
    }
}
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container=container;
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+container.pop()+"个产品");

        }
    }

}
class Product{
    int id;

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+"";
    }
}
class SynContainer{
    //容器
    Product products[]=new Product[10];
    int count=0;
    //生产者放入产品
    public synchronized void push(Product product){
        //如果容器满了，就需要等待消费者消费
        if (count==products.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        //如果没有满，则放入产品
        products[count]=product;
        count++;
        //可以通知消费者消费了
        this.notifyAll();

    }
    //消费者消费产品
    public synchronized Product pop(){
        if(count==0){
            //等待
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count--;
        Product product = products[count];
        //用完了，通知生产者生产
        this.notifyAll();
        return product;
    }
}
