package com.stack;

public class StackNode {
    int no;
    StackNode next;

    public StackNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public StackNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "no=" + no +
                '}';
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
