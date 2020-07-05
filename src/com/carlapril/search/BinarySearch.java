package com.carlapril.search;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-07-05 22:26
 */
//使用二分查找，确保数组是有序的！！
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,999};
        int index = binarySearch(arr,0,arr.length-1,1000);
        if (index==-1){
            System.out.println("未找到该数据");
        }else {
            System.out.println("index = " + index);
        }

    }

    /**
     *
     * @param arr 数组
     * @param left 数组左引索
     * @param right 数组右引索
     * @param findVal 需要查找的值
     * @return 返回查找到的值的下标，没有查到返回-1
     */
    public static int binarySearch(int[] arr, int left,int right, int findVal){
         int mid = (right+left)/2;
         if(left>right){
             return -1;
         }
         if (findVal> arr[mid]){//已知数组是升序
             return binarySearch(arr, mid+1, right, findVal);
         }else if (findVal<arr[mid]){
             return binarySearch(arr, left, mid-1, findVal);
        }else{
             return mid;
         }
    }
}
