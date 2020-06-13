package com.hashtab;
//无头节点
public class EmpLinkedList {
    private Emp head;//直接指向第一个有效对象
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        Emp temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=emp;
    }
    public void list(){
        if(head==null){
            System.out.println("当前链表为空");
            return;
        }
        System.out.println();
        Emp temp=head;
        while (true){
            System.out.println(temp);
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
    }
    public Emp searchEmpById(int id){
        if(head==null){
            System.out.println("链表空");
            return null;
        }
        Emp temp=head;
        while (true){
            if(temp.id==id){
                break;
            }
            if(temp.next==null){
                temp=null;
                break;
            }
            temp=temp.next;
        }

        return temp;
    }
}
