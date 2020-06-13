package com.tree;

public class ArrBinaryTree {
    int arr[];

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        ArrBinaryTree arrBinaryTree=new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void preOrder(int index){
        if(arr==null||arr.length==0){
            return;
        }
        System.out.print(arr[index]+" ");
        if((2*index+1)<arr.length) {
            preOrder(2 * index + 1);
        }
        if((2*index+2)<arr.length){
            preOrder(2*index+2);
        }
    }
    public void infixOrder(int index){
        if(arr==null||arr.length==0){
            return;
        }

        if((2*index+1)<arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.print(arr[index]+" ");
        if((2*index+2)<arr.length){
            infixOrder(2*index+2);
        }
    }
}
