package com.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[]={7,9,-1,45,2,1,9,38};
        int temp[]=new int[arr.length];
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int arr[]){
        int temp[]=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }
    public static void mergeSort(int arr[],int left,int right,int temp[]){
        if (left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }


    }
    public static void merge(int arr[],int left,int mid,int right,int temp[]){
        int i=left;
        int j=mid+1;
        int t=0;//temp指针
        while (i<=mid&&j<=right){//有序的存入temp数组
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }else {
                temp[t++]=arr[j++];
            }
        }
        //将剩余元素拷贝进temp数组
        while (i<=mid){
            temp[t++]=arr[i++];
        }
        while (j<=right){
            temp[t++]=arr[j++];
        }
        //把temp数组拷贝进原数组
        for (i=left,t=0;i<=right;i++,t++){
            arr[i]=temp[t];
            
        }
    }
}
