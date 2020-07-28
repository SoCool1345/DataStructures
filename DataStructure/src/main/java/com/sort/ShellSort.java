package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class ShellSort {
    public static void main(String[] args) {
        int maxSize = 100000000;
        int arr[] = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxSize);
        }
//        int arr[]={4,6,8,5,9};
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        shellSort2(arr);
        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));

    }
//直接交换
    public static void shellSort(int[] arr) {
        Stack a[]=new Stack[10];
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;

                    }

                }
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    public static void shellSort2(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }
}
