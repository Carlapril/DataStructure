package com.carlapril.queue;

import java.util.Scanner;

/**
 * @author carlapril
 * @create 2020-05-03 14:53
 */
public class Queue {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接受用户
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到数列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):显示头数据");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);//接收一个字符
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
    //编写一个数组模拟队列
    class ArrayQueue {
        public int maxSize;
        private int front;
        private int rear;
        private int[] arr;//模拟数列

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }

        //判断队列是否为满
        public boolean isFull() {
            return rear == maxSize - 1;
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
            rear++;
            arr[rear] = i;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，无法取数据");
            }
            front++;
            return arr[front];
        }

        //显示队列所有数据
        public void showQueue() {
            //遍历
            if (isEmpty()) {
                System.out.println("队列为空");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", arr[i]);
            }
        }

        //显示头数据
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("空队列");
            }
            return arr[front + 1];
        }
    }
