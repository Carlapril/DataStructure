package com.carlapril.sort;

/**
 * @author carlapril
 * @create 2020-06-11 22:29
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,10,0,17,100};
       int[] arrs =  bubbleSort(arr);
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i]+" ");
        }

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
