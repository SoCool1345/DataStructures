package com.hashtab;

public class HashTab {
    EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size){
        this.size=size;
        empLinkedListArray=new EmpLinkedList[size];
        //必须分别初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        int index=hashFun(emp.id);//要加入到那条链表
        empLinkedListArray[index].add(emp);
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }
    public void searchEmpById(int id){
        Emp emp=empLinkedListArray[hashFun(id)].searchEmpById(id);
        if(emp!=null){//找到
            System.out.println(emp);
        }else {
            System.out.println("没有找到");
        }
    }
    public int hashFun(int id){
        return id%size;
    }
}
