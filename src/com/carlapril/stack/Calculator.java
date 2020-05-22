package com.carlapril.stack;

import javax.sound.midi.Soundbank;
import java.text.BreakIterator;

/**
 * @author carlapril
 * @create 2020-05-19 20:27
 */
public class Calculator {
    public static void main(String[] args) {
        String string = "400+6*30-2";
        ArrayStack1 numStack1 = new ArrayStack1(10);
        ArrayStack1 operStack1 = new ArrayStack1(10);
        int num1;
        int num2 ;
        int index = 0;//用于表达式的扫描
        int res ;
        int oper;
        String keepNum = "";//拼接多位数
        char ch = ' ';
        while (true) {
            ch = string.substring(index, index + 1).charAt(0);
            if (operStack1.isOper(ch)) {
                //判断是否为空
                if (!operStack1.isEmpty()) {
                    //处理
                    if (operStack1.priority(ch) <= operStack1.priority(operStack1.peek())) {
                        num1 = numStack1.pop();
                        num2 = numStack1.pop();
                        oper = operStack1.pop();
                        res = numStack1.calculate(num1, num2, oper);
                        numStack1.push(res);
                        //将符号再入符号栈
                        operStack1.push(ch);
                    } else {
                        operStack1.push(ch);
                    }
                } else {
                    operStack1.push(ch);
                }
            } else {
                //numStack1.push(ch - 48);
                //入数栈时要检验是否为多位数
                keepNum += ch;
                if (index == string.length() - 1) {
                    numStack1.push(Integer.parseInt(keepNum));
                    keepNum = "";

                } else {
                    while (!(operStack1.isOper(ch = string.substring(index + 1, index + 2).charAt(0)))) {
                        keepNum += ch;
                        index++;
                    }
                    numStack1.push(Integer.parseInt(keepNum));
                    keepNum = "";

                }
            }

            index++;
            if (index > string.length() - 1) {
                break;
            }
        }

        while (true) {
            if (operStack1.isEmpty()) {
                break;
            }
            num1 = numStack1.pop();
            num2 = numStack1.pop();
            oper = operStack1.pop();
            res = numStack1.calculate(num1, num2, oper);
            numStack1.push(res);
        }
        System.out.println("结果：" + numStack1.pop());

    }

}

class ArrayStack1 {
    private int maxSize;//栈的大小
    private int[] stack;//栈数据
    private int top = -1;

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
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

    //返回运算符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//非法运算符
        }

    }

    //判断是否为运算符
    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //计算方法
    public int calculate(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;

        }
        return res;
    }

    public int peek() {
        return stack[top];
    }

}

