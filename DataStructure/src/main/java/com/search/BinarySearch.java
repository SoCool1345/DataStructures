package com.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {-8, 9, 14, 22, 38, 77, 98};
        System.out.println(binarySearch(arr, 0));

    }

    public static int binarySearch(int arr[], int findVal, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;


        if (findVal > arr[mid]) {//向右
            return binarySearch(arr, findVal, mid + 1, right);
        } else if (findVal < arr[mid]) {//向左
            return binarySearch(arr, findVal, left, mid - 1);
        } else {
            return mid;
        }

    }

    //所有value
    public static ArrayList binarySearch2(int arr[], int findVal, int left, int right) {
        if (left > right) {
            return new ArrayList();
        }
        int mid = (left + right) / 2;


        if (findVal > arr[mid]) {//向右
            return binarySearch2(arr, findVal, mid + 1, right);
        } else if (findVal < arr[mid]) {//向左
            return binarySearch2(arr, findVal, left, mid - 1);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            //向mid左边找
            while (true) {
                if (temp < 0 || arr[temp] != arr[mid]) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            //向mid右边找
            temp = mid + 1;
            //向mid左边找
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != arr[mid]) {
                    break;
                }
                list.add(temp);
                temp++;
            }

            return list;
        }

    }

    public static int binarySearch(int arr[], int findVal) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == findVal) {
                return mid;
            } else if (findVal < arr[mid]) {//向左
                right = mid - 1;
            }else if(findVal > arr[mid]){
                left=mid+1;
            }
        }
        return -1;
    }

}
