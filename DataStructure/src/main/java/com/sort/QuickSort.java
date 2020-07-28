package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int maxSize = 100000000;
        int arr[] = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxSize);
        }
//        int arr[]={4,6,8,5,9};
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss.SSS");
        System.out.println(simpleDateFormat.format(date));
        quickSort(arr);
        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));
        //System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int arr[]){
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int arr[],int left,int right){
        int l=left;
        int r=right;
        if (l<r){
        int pivot=arr[left];
        while (l<r){
            while (l<r&&pivot<arr[r]){//找比pivot小的数
                r--;
            }
            if (l<r){
                arr[l++]=arr[r];
            }
            while (l<r&&pivot>arr[l]){
                l++;
            }
            if (l<r){
                arr[r--]=arr[l];
            }
        }
        arr[l]=pivot;
        quickSort(arr,left,r-1);
        quickSort(arr,l+1,right);
        }
    }
}
