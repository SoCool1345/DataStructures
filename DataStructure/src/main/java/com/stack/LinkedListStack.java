package com.stack;

public class LinkedListStack {
    StackNode top=new StackNode(-1);
    public boolean isEmpty(){
        return top.getNext()==null;
    }

    public void push(StackNode node){
        if(top.getNext()==null){
            top.setNext(node);
            return;
        }
        StackNode temp=top;
        node.setNext(temp.getNext());
        top.setNext(node);
    }
    public void pop(){
        System.out.println(top.getNext()+"出栈");
        top=top.getNext();
    }
    public void show(){
        if(isEmpty()){
            System.out.println("栈为空");
        }
        StackNode temp=top;
        while (true){
            if(temp.getNext()==null)break;
            System.out.println(temp.getNext().getNo());
            temp=temp.getNext();
        }
    }


}

