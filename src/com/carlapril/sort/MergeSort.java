package com.carlapril.sort;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-06-30 22:02
 */
public class MergeSort {
    public static void main(String[] args) {
      int[] arr = {9,4,5,7,1,3,6,2};
      int [] temp = new int[arr.length];
      mergeSort(arr,0,7,temp);
        System.out.println("分治排序后："+ Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {

          mergeSort(arr,left,mid,temp);//左递归
            mergeSort(arr,mid+1, right, temp);//向右递归
            merge(arr,left,mid,right,temp);

        }

    }

    /**
     * @param arr   传入的数组
     * @param left  数组左引索
     * @param mid   数组中位数引索
     * @param right 数组末尾引索
     * @param temp  临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
//        int r = right;
        int tempNum = mid + 1;
        int i = 0;
          while (l <= mid && tempNum <= right) {//将数据放入临时数组中
            if (arr[l] < arr[tempNum]) {
                temp[i] = arr[l];
                i++;
                l++;
            } else {
                temp[i] = arr[tempNum];
                i++;
                tempNum++;
            }

        }
        //如果有未放入的数据
        while (l <= mid) {//左边未放置完毕时，将剩余数据放入临时数组
            temp[i] = arr[l];
            i++;
            l++;
        }
        while (tempNum <= right) {//同理，将右边数据放入
            temp[i] = arr[tempNum];
            i++;
            tempNum++;
        }
        //将数据放回原数组
        i = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[i];
            tempLeft++;
            i++;
        }

    }
}
