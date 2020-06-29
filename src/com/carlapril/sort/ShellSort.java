package com.carlapril.sort;

import java.awt.*;
import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-06-17 21:38
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
    }

    public static void shellSort1(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = (j - i); k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;

                    }

                }

            }
        }
        System.out.println("shell排序后：");
        System.out.println(Arrays.toString(arr));
//        for (int j = 0, k = arr.length / 2; j < arr.length / 2; j++, k++) {
//            if (arr[j] > arr[k]) {
//                temp = arr[j];
//                arr[j] = arr[k];
//                arr[k] = temp;
//            }
//        }
//        System.out.println("第一次shell排序后：");
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0, j = (int) (arr.length / (Math.pow(2, 2))); j < arr.length; i++, j++) {
//            if (arr[i] > arr[j]) {
//                temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        System.out.println("第二次shell排序后：");
//        System.out.println(Arrays.toString(arr));


    }

    //对交换式的shell进行优化
    public static void shellSort2(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int insertValue = arr[j];
                int insertIndex = j - i;
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex +i] = arr[insertIndex];
                    insertIndex -= i;

                }
                arr[insertIndex+i] = insertValue;
            }
        }
        System.out.println("shell排序后：");
        System.out.println(Arrays.toString(arr));
    }
}