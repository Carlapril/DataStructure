package com.carlapril.linkedlist;

import com.sun.tools.javac.Main;

import java.text.BreakIterator;

/**
 * @author carlapril
 * @create 2020-05-12 20:12
 */
public class Josephus {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(5);
        circleLinkedList.showBoy();
        circleLinkedList.countBoy(1,2,5);
    }
}


//创建环形链表
class CircleLinkedList {
    private Boy first = new Boy(-1);

    //添加小孩节点
    public void addBoy(int num) {
        //对num做数据校验
        if (num < 1) {
            System.out.println("NUM不正确");
            return;
        }
        Boy tempBoy = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                tempBoy = first;
            } else {
                tempBoy.setNext(boy);
                boy.setNext(first);
                tempBoy = boy;
            }
        }
    }

    //遍历当前环形列表
    public void showBoy() {
        //判斷链表是否为空
        if (first.getNo() == -1) {
            System.out.println("链表为空");
            return;
        }
        Boy tempBoy = first;
        while (true) {
            System.out.println("tempBoy = " + tempBoy);
            if (tempBoy.getNext() == first) {
                break;
            }
            tempBoy = tempBoy.getNext();
        }
    }

    /**
     * @param startNo//表示从第几个小孩开始数数
     * @param countNum  //数几次
     * @param numOfBoy//小孩的个数
     */
    public void countBoy(int startNo, int countNum, int numOfBoy) {
        if (first.getNo() == -1 | startNo < 1 | startNo > numOfBoy) {
            System.out.println("数据异常，无法完成数数游戏");
            return;
        }
        //定义一个辅助指针
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //在报数前，先让头节点和helper节点移动到startNo前后
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        //开始报数，头节点和helper节点移动countNum-1次,然后出圈。
        while (true) {
            if (first == helper) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println("出圈的小孩是" + first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后在圈内的是" + helper);

    }
}

class Boy {
    private int no;//编号
    private Boy next;

    public Boy(int no) {
        this.no = no;

    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}