package com.carlapril.sort;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-06-28 21:03
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=(int) (Math.random()*200);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * @param arr   数列
     * @param left  数列头
     * @param right 数列尾
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];//中位下标的值
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
             if (arr[r] == pivot) {
                l += 1;
            }
             if (arr[l]==pivot){
                r-=1;
            }

        }
        if (l==r){
            l++;
            r--;
        }
//        System.out.println("第一次排完："+ Arrays.toString(arr));
        if (left < r) {//向左递归
            quickSort(arr, left, r);
        }
        if (right>l){
          quickSort(arr, l, right);
        }
    }
}

