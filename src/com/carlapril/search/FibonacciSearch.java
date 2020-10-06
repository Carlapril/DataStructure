package com.carlapril.search;

import java.util.Arrays;

/**
 * @author carlapril
 * @create 2020-10-06 15:24
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1034};
        int index = fibSearch(arr, 8);
        System.out.println("index = " + index);
    }

    public static int[] fibArray() {
        int[] fib = new int[20];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * @param arr 数组
     * @param key arr数组中要查找的值
     * @return 返回查找到的值的下标，没有则返回-1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示fib数列中分割位置的下标
        int mid = 0;
        int[] fib = fibArray();//获取数列
        while (high > fib[k] - 1) {//数组长度比fib[k]-1的长时，需要增大k值【fib数列好比一个arr数组的线段尺子，fib有天然黄金分割比例的特点】
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k]);//复制一个临时数组
        if (fib[k] > arr.length) {
            //给复制后的数组大于arr.length后的值赋值
            for (int i = arr.length; i < temp.length; i++) {
                temp[i] = arr[high];
            }
        }
        while (low <= high) {
            mid = fib[k - 1] - 1 + low;
            if (key < temp[mid]) {//需要向黄金分割的前部分查找
                high = mid - 1;
                k--;//再次循环时，有fib[k-1]个元素（长度）
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;//再次循环时，有fib[k-2]个元素（长度）
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }

        }
        return -1;

    }
}
