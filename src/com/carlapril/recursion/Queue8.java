package com.carlapril.recursion;

import java.util.zip.CheckedInputStream;

/**
 * @author carlapril
 * @create 2020-06-09 21:22
 */
public class Queue8 {
    int max = 8;//皇后的个数
    int[] arr = new int[max];//保存皇后放置的位置
    static int count;
    static int judgeCount;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有多少种解法："+count);
        System.out.println("一共回溯的次数："+judgeCount);
    }


    private void check(int n){
        if (n==max){
            print();
            return;
        }else{
         for (int i = 0; i < max; i++) {
             arr[n] = i;
             if (judge(n)) {
                 check(n + 1);
             }
         }
        }
    }

    private boolean judge(int n) {//第N个皇后是否与前面冲突
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //由于在对角线上时，行和列的值是相同的
            //n代表行，arr[n]代表列值（0，1，2，3，4，5，6，7）
            //arr[i] == arr[n]表示在同一列
            if (arr[i] == arr[n] || Math.abs(arr[n] - arr[i]) == Math.abs(n - i)){
                return false;
            }
        }
        return true;
    }

    private void print() {//打印八皇后的站位
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}