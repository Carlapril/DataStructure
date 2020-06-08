package com.carlapril.recursion;

/**
 * @author carlapril
 * @create 2020-06-08 19:46
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
        int result = factorial(4);
        System.out.println("result = " + result);
    }
    public static void test(int n){//递归打印
        if (n>2){
            test(n-1);
        }
        System.out.println("n = " + n);
    }
    public static int factorial(int n){//阶乘
        if (n==1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }

}
