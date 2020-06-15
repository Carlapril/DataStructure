package com.carlapril.sort;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-06-14 21:17
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {2, 7, 8, 10, 1};
//        int[] arr1 = selectSortSmallToBig(arr);
//        System.out.println(Arrays.toString(arr1));
        int[] arr = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr[i]=(int) (Math.random()*50000);
        }
        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));
        Long l1 = System.currentTimeMillis();
        int[] arrs =  selectSortSmallToBig(arr);
        Long l2 = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arrs));
        System.out.println("耗时为："+(l2-l1));

    }

    public static int[] selectSortSmallToBig(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];//假设第一个最小
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (temp > arr[j]) {
                    temp = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = temp;
//            temp =arr[1+i];
            }
        }
        return arr;
    }
}
