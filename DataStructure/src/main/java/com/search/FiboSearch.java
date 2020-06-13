package com.search;

import java.util.Arrays;

public class FiboSearch {
    public static int maxsize=21;
    public static void main(String[] args) {
        int arr[]={2};
//        int f[]=fibo();
//        System.out.println(Arrays.toString(f));
        System.out.println(fiboSearch(arr, 2));

    }
    public static int[] fibo(){
        int[] f=new int[maxsize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < maxsize; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //mid=low+f[k-1]-1
    public static int fiboSearch(int arr[], int findVal) {
        if(arr.length==0){
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int k = 0;
        int f[] = fibo();
        //获取k
        while (arr.length > f[k]-1) {
            k++;
        }
        //填充数组
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (temp[mid] > findVal) {//向左
                high = mid - 1;
                k--;
            } else if (temp[mid] < findVal) {//向右
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else return high;

            }
        }
        return -1;

    } 
    
}
