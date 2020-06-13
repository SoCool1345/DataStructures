package com.linkedlist;

public class CircleSingleLinkedList {
    //创建first节点
    private Boy first=null;
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;
        for (int i = 1; i <nums+1 ; i++) {
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);//构成环
                curBoy=first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }

        }
    }
    //遍历当前链表
    public void showBoy(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy=first;
        while (true) {
            System.out.println(curBoy.getNo());
            if(curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }
    //根据用户输入，计算出圈顺序
    public void countBoy(int startNo,int countNum,int nums){
        if(first==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误");
            return;
        }
        Boy helper=first;//尾指针
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if(helper==first){//圈中只有一个节点
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            //这时first指向要出圈的节点
            System.out.println(first.getNo()+"出圈");
            //出圈
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后编号"+first.getNo());
    }
}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
