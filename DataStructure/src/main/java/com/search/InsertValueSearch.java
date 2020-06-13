package com.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[]=new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        System.out.println(insertValueSearch(arr, 10, 0, 99));
    }
    //mid=left+(right-left)*(findVal-arr[left])/arr[right]-arr[left])
    public static int insertValueSearch(int arr[],int findVal,int left,int right){
        System.out.println("~~");
        if(findVal>arr[right]||findVal<arr[left]||left>right){
            return -1;
        }

        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        if(findVal<arr[mid]){//向左
            return insertValueSearch(arr,findVal,left,mid-1);
        }else if (findVal>arr[mid]){//向右
            return insertValueSearch(arr,findVal,mid+1,right);
        }else {
            return mid;
        }
    }
}
