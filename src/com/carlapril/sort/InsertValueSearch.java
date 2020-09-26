package com.carlapril.sort;

/**
 * @author carlapril
 * @create 2020-09-26 21:40
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] ints = new int[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        int index = insertValueSearch(ints,0,ints.length-1,-1);
        if (index == -1){
            System.out.println("未查询到该值，请重新输入");
        }else{
            System.out.println("index = " + index);
        }
    }

    /**
     * @param arr       有序数组
     * @param left      左下标
     * @param right     右下标
     * @param findValue 需要查找的值
     * @return           查找到返回下标，否则返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        //findValue需要判断，不判断可能数组下标越界
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findValue > midVal) {
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else if (findValue < arr[mid]) {
             return insertValueSearch(arr, left, mid-1, findValue);
        }else{
            return mid;
        }

    }
}



