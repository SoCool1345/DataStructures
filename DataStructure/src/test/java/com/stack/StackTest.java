package com.stack;

import org.junit.Test;

public class StackTest {
    @Test
    public void StackTest(){
        LinkedListStack linkedListStack=new LinkedListStack();
        StackNode node1=new StackNode(1);
        StackNode node2=new StackNode(5);
        StackNode node3=new StackNode(3);
        StackNode node4=new StackNode(5);
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        linkedListStack.push(node4);
        linkedListStack.show();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.show();
    }
    @Test
    public void StackTest1(){
        Calculator calculator = new Calculator();
        String expression="30+7*2-4/2";
        System.out.println(calculator.calculator(expression));
    }
}
