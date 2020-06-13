package com.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[]arr={7,9,-1,45,2,1,9,38};
        SelectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }



    //从小到大排序
    public static void selectSort(int [] array){
        int min;

        int subscript;
        for (int i = 0; i < array.length-1; i++) {
            min=array[i];
            subscript=i;
            for (int j = i; j < array.length-1; j++) {
                if(min>array[j+1]){
                    min=array[j+1];
                    subscript=j+1;
                }
            }
            array[subscript]=array[i];
            array[i]=min;

            System.out.println(Arrays.toString(array));

        }
    }


}
