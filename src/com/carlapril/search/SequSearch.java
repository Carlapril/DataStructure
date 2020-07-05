package com.carlapril.search;

/**
 * @author carlapril
 * @create 2020-07-05 21:49
 */
public class SequSearch {
    public static void main(String[] args) {
        int[] arr = {0,3,7,-1,5,10};
        int value=sequSearch(arr,5);
        if (value==-1){
            System.out.println("该数组不含有该值");
        }else{
            System.out.println("数组含有该值，下标为："+value);
        }

    }
    public static int sequSearch(int[]arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
