package com.carlapril.linkedlist;

import java.util.Stack;

/**
 * @author carlapril
 * @create 2020-05-07 21:41
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("xiaoyu");
        stack.add("manko");
        stack.add("dacong");
        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());//pop就是将数据取出；先进后出。
        }


    }
}
