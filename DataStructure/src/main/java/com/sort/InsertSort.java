package com.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[]arr={7,9,-1,45,2,1,9,38,88};
        InsertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int [] array){
        int insertval;
        int index;
        for (int i = 1; i < array.length; i++) {//遍历无序表
            insertval=array[i];
            index=i-1;
            while (index >= 0 && insertval<array[index]) {//>从大到小
                array[index+1]=array[index];
                index--;
            }
            if(index+1!=i)array[index+1]=insertval;//上面index--

            System.out.println(Arrays.toString(array));
        }
    }

}
