package com.search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[]={1,11,6,-1,34};
        System.out.print( SeqSearch.seqSearch(arr, 9));
    }
    public static int seqSearch(int[]arr,int value){
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]==value){
                return j;
            }
        }
        return -1;
    }
}
