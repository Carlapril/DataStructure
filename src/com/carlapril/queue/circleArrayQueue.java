package com.carlapril.queue;

import java.util.Scanner;

/**
 * @author carlapril
 * @create 2020-05-04 13:40
 */
public class circleArrayQueue {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到数列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):显示头数据");
            System.out.println("e(exit):退出");
            //接收一个字符
            //接受用户
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println(" 请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("res = " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("res = " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }


        }
        System.out.println("程序退出");
    }
}


class CircleArray {
    public int maxSize;
    private int front;//指向第一个元素，初始值=0
    private int rear;//指向最后一个元素的后一个位置,初始值为0
    private int[] arr;//模拟数列

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int i) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，无法加入数据");
            return;
        }
        arr[rear] = i;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //返回环形队列的大小
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("空队列");
        }
        return arr[front];
    }
}