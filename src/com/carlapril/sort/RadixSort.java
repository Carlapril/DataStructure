package com.carlapril.sort;

import java.nio.channels.AsynchronousChannel;
import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-07-05 12:21
 */
public class RadixSort {
    public static void main(String[] args) {
    int[] arr = {53,3,542,748,14,214};
    radixSort(arr);
    }


    public static void radixSort(int[] arr) {
        int max = arr[0];//先定义一个最大值
        for (int i = 1; i < arr.length; i++) {//获取最大值
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        int maxLength = (max + "").length();//获取最大值的位数
        int[][] bucket = new int[10][arr.length];//由于0-9共10个，定义10个桶
        int[] bucketElementCounts = new int[10];
        for (int l = 0,n=1; l < maxLength; l++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfNumber = arr[i] / n % 10;//取出位数上的数字
                bucket[digitOfNumber][bucketElementCounts[digitOfNumber]] = arr[i];//放在对应桶内
                bucketElementCounts[digitOfNumber]++;//此桶内放入几个数
            }
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {//遍历十个桶，有数字就取出来给予原数组
                if (bucketElementCounts[j] != 0) {//如果第j个桶有数据，进入
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];//取桶内数据,并自增加1

                    }

                }

                bucketElementCounts[j] = 0;
            }
        }

        System.out.println("排序后"+ Arrays.toString(arr));
    }
}
