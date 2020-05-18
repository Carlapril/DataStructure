package com.carlapril.stack;

import java.security.Key;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author carlapril
 * @create 2020-05-18 20:09
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String str = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("push:表示添加数据入栈");
            System.out.println("pop:表示从栈中取出数据");
            System.out.println("exit:退出程序");
            String key = scanner.next();
            switch (key) {
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    if (stack.isFull()){
                        System.out.println("栈满，请先出栈");
                        break;
                    }
                    System.out.println("请输入一个数据");
                    int temp = scanner.nextInt();
                    stack.push(temp);
                    break;
                case "pop":
                    try {
                        int value = stack.pop();
                        System.out.println("出栈的数据数：" + value);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出");
    }
}

class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//栈数据
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        if (top == maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("数据已满，入栈失败");
            return;
        }
        top++;
        stack[top] = num;
        System.out.println("入栈成功");
    }

    public int pop() {
        if (isEmpty()) {
            //  System.out.println("栈空");
            throw new RuntimeException("栈空");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    //显示栈的情况
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈为空，无数据");
        }
        //需要从栈顶显示数据
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
