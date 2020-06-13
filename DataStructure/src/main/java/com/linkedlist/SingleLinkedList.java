package com.linkedlist;

import java.util.LinkedList;

public class SingleLinkedList {
    //初始化头结点
    private HeroNode head=new HeroNode(0,"");

    public void setHead(HeroNode head) {
        this.head = head;
    }

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单链表
    public void add(HeroNode node){
        HeroNode temp=head;
        //遍历链表
        while (temp.next!=null){
            temp=temp.next;
        }
        //temp指向链表最后
        temp.next=node;
    }
    //按顺序添加
    public void addByOrder(HeroNode node){
        HeroNode temp=head;
        boolean flag=false;//添加编号是否存在
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no>node.no){
                break;
            }
            else if(temp.next.no==node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println("编号"+node.no+"重复");
        }else {
            node.next=temp.next;
            temp.next=node;
        }
    }
    //修改节点信息
    public void update(HeroNode node){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.no==node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name=node.name;
        }else System.out.println("没有找到编号"+node.no);
    }
    //删除节点
    public void delete(int no){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else System.out.println("没有找到编号"+no);
    }
    //显示链表
    public void list(){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        while (temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
}


