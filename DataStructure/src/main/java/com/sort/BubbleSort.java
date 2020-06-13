package com.sort;

import java.util.Arrays;

public class BubbleSort {
    int array[]={7,9,-1,45,2,1,9,38};
    Boolean flag=false;//有没有发生交换
    public static void main(String[] args) {
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.sort();

    }
    public void sort(){

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1])swap(j);
            }
            System.out.println("第"+(i+1)+"趟");
            System.out.println(Arrays.toString(array));
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
    //交换
    public void swap(int n){
        flag=true;
        int temp;
        temp=array[n];
        array[n]=array[n+1];
        array[n+1]=temp;
    }

}
