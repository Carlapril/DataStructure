package com.carlapril.sparsearray;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author carlapril
 * @create 2020-05-03 13:16
 */
public class SparseArr {
    public static void main(String[] args) {
        //创建数组 11*11 0表示没有子，1，2表示双方子。
        int[][] chaseArr = new int[11][11];
        chaseArr[1][2] = 1;
        chaseArr[2][3] = 2;
        //  输出一下数组
        System.out.println("原始的二维数组:");
        for (int[] ints : chaseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        //将棋盘二维数组转化为稀疏数组
        int sum = 0;
        for (int i = 0; i < chaseArr.length; i++) {
            for (int j = 0; j < chaseArr.length; j++) {
                if (chaseArr[i][j] != 0) {
                    sum++;
                }

            }
        }
        System.out.println("sum = " + sum);
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chaseArr.length; i++) {
            for (int j = 0; j < chaseArr.length; j++) {
                if (chaseArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chaseArr[i][j];
                }

            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("输出的稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
        //将稀疏数组再转回原始二维数组
        //先读取第一行数据
        int[][] chessArr1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("还原的原始的二维数组:");
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

}







