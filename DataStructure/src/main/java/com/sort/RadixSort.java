package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        int maxSize = 50000000;
        int arr[] = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxSize);
        }
//        int arr[]={4,6,8,5,9};
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        radixSort(arr);
        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));
        //System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int arr[]) {
        int tong[][] = new int[10][arr.length];
        int index;//arr数组指针
        int maxNum = 0;
        int digit = 0;
        int key[] = new int[10];//记录每个桶的指针移动位置
        int num;//在第i位上的数字
        //找出最大数
        for (int i : arr) {
            if (maxNum < i) {
                maxNum = i;
            }
        }
        //计算最大数的位数
        digit = (maxNum + "").length();
        for (int i = 0, n = 1; i < digit; i++, n *= 10) {
            for (int i1 : arr) {//装桶
                num = i1 / n % 10;
                tong[num][key[num]++] = i1;
            }
            index = 0;
            //重新排列数组
            for (int i1 = 0; i1 < tong.length; i1++) {//遍历桶
                if (key[i1] != 0) {
                    for (int i2 = 0; i2 < key[i1]; i2++) {
                        arr[index] = tong[i1][i2];//重新排列数组
                        index++;
                    }
                }
            }
            key=new int[10];
        }
    }
}
