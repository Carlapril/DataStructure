package com.carlapril.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-06-15 22:00
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {3,1,6,2,0};
//        int[] arrs=insertSort(arr);
//        System.out.println(Arrays.toString(arrs));
        int[] arr = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr[i]=(int) (Math.random()*50000);
        }
        System.out.println("排序前：");
//        System.out.println(Arrays.toString(arr));
        Long l1 = System.currentTimeMillis();
        int[] arrs =  insertSort(arr);
        Long l2 = System.currentTimeMillis();
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arrs));
        System.out.println("耗时为："+(l2-l1));

    }

    public static int[] insertSort(int @NotNull [] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int insertVal = arr[i + 1];
            int insertIndex = i;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
        return arr;
    }
}
