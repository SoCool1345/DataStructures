package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

public class HeapSort {

    public static void main(String[] args) {
        int maxSize=10000000;
        int arr[]=new int[maxSize];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*maxSize);
        }
//        int arr[]={4,6,8,5,9};
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh-mm-ss");
        System.out.println(simpleDateFormat.format(date));
        heapSort(arr);
        Date date1=new Date();
        System.out.println(simpleDateFormat.format(date1));
    }
    public static void heapSort(int arr[]){
        int temp;
        //创建大顶堆，从下至上，从右往左
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }



        for (int i = arr.length-1; i > 0; i--) {
            //交换i
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            //调整大顶堆
            adjustHeap(arr,0,i);
        }


    }

    /**
     *
     * @param arr 将arr变成大顶堆
     * @param i 需要调整的子树位置
     * @param length 需要调整的数字长度
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp=arr[i];

        for (int k=2*i+1;k<length;k=2*k+1){
            //右子节点存在才比较
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            //如果叶子节点更大，则交换
            if(arr[k]>temp){
                arr[i]=arr[k];
                //i指向k,向下调整子节点
                i=k;
            }else {
                break;
            }
        }

        arr[i]=temp;
    }
}
