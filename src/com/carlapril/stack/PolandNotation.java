package com.carlapril.stack;

import org.jetbrains.annotations.NotNull;

import javax.lang.model.SourceVersion;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author carlapril
 * @create 2020-06-03 20:48
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("infixExpressionList = " + infixExpressionList);//>==[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        List<String> suffixExpression = toSuffixExpressionList(infixExpressionList);
        System.out.println("suffixExpression = " + suffixExpression);

//         String suffixExpression = "3 4 + 5 * 6 -";
//         List<String> rpnList = getListString(suffixExpression);
//        System.out.println("rpnList = " + rpnList);
//        int result = calculate(rpnList);
//        System.out.println("result = " + result);

    }
    public static List<String> toSuffixExpressionList(List<String> ls){
        List<String> arrayList = new ArrayList<>();//存放逆序表达式
        Stack<String> stack = new Stack<>();//存放符号
        for (String item : ls) {
            if (item.matches("\\d+")) {
                arrayList.add(item);
            }else if (item.equals("(")){
                stack.push(item);

            }else if (item.equals(")")){
                while (!stack.peek().equals("(")){
                    arrayList.add(stack.pop());
                }
                stack.pop();
            }else{
                while (stack.size()!=0&& Operation.getValue(stack.peek())>= Operation.getValue(item)){
                    arrayList.add(stack.pop());
                }
                stack.push(item);
            }

        }
        while (stack.size()!= 0){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;//用于拼接多位数
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }

        } while (i < s.length());
        return list;
    }

    public static List<String> getListString(@NotNull String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> strings = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                strings.push(s);
            } else {
                int num1 = Integer.parseInt(strings.pop());
                int num2 = Integer.parseInt(strings.pop());
                int result = 0;
                if (s.equals("+")) {
                    result = num1 + num2;
                } else if (s.equals("-")) {
                    result = num2 - num1;
                } else if (s.equals("*")) {
                    result = num1 * num2;
                } else if (s.equals("/")) {
                    result = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                strings.push(result + "");
            }
        }
        return Integer.parseInt(strings.pop());
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String key) {
        int res = 0;
       switch (key){
           case "+":
                res = ADD;
                break;
           case "-":
               res = SUB;
               break;
           case "*":
               res = MUL;
               break;
           case "/":
               res = DIV;
               break;
           default:
               break;
//               throw new RuntimeException("运算符有误");
       }
       return res;
    }


}