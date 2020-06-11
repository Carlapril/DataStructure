package com.carlapril.sort;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-06-11 22:29
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr[i]=(int) (Math.random()*50000);
        }
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
       Long l1 = System.currentTimeMillis();
       int[] arrs =  bubbleSort(arr);
       Long l2 = System.currentTimeMillis();
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arrs));
        System.out.println("耗时为："+(l2-l1));


    }
    public static int[] bubbleSort(int[] arrs){
        boolean flag = false;//定义旗帜，如果在一次冒泡中一次都未交换，直接break
        int temp;
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length-i-1; j++) {
                if (arrs[j]>=arrs[j+1]){
                    flag = true;
                    temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1]= temp;
                }
            }
            if (!flag){
                System.out.println("已为您优化算法");
                break;
            }else{
                flag = false;
            }
        }
        return arrs;
    }
}
