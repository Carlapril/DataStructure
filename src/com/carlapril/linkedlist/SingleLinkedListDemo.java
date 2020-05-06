package com.carlapril.linkedlist;

import java.awt.*;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @author carlapril
 * @create 2020-05-04 14:40
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
//创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();//创建链表
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.list();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.list();//顺序仍然是按顺序添加
        HeroNode heroNode0 = new HeroNode(2, "小卢卢", "玉麒麟！！");
        singleLinkedList.update(heroNode0);
        singleLinkedList.list();
        singleLinkedList.delete(3);
        System.out.println();
        singleLinkedList.list();
        System.out.println(getLength(singleLinkedList.getHead()));
        //测试取倒是第n个节点
        HeroNode hero = findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.println("hero = " + hero);


    }
    //返回倒数第K个节点
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        //得到链表的长度
        int size = getLength(head);
        //首先考虑数据的合理性
        if (index<=0||index>size){
            System.out.println("输入的数据不合理");
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //獲取单链表的节点个数
    public static int getLength(HeroNode head){
        int length = 0;
        HeroNode temp = head.next;
        if (head.next == null) {
            return 0;
        }
        while (temp!= null){
            length++;
            temp=temp.next;
        }
        return length;
    }


}

//定义SingleLinkedList管理英雄
class SingleLinkedList {
    //定义一个头节点，不要动。
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点的方法
    public HeroNode getHead(){
        return head;
    }
    //添加节点到单向链表
    public void add(HeroNode heroNode) {
        //先用临时节点找到头，遍历
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //加入一个新方法，将对象插入到指定节点
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.number > heroNode.number) {
                break;
            } else if (temp.next.number == heroNode.number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("待插入的英雄标号已存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改英雄信息,根据提供的HeroNode的编号修改
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //先定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//到了链表的最后
            }
            if (temp.number == heroNode.number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
            System.out.println("信息已修改");
        } else {
            System.out.println("未找到传入的英雄所对应的编号，信息未修改！");
        }

    }

    //删除节点
    public void delete(int number) {
        HeroNode temp = head;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.number == number) {
                flag = true;//证明我们找到了该编号的英雄，把flag至真
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("输入的序号有误，请确认是否有该编号英雄！！");
        }

    }

    //显示链表，遍历
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;//一定要重新赋值，不然死循环
        }
    }
}

//定义HeroNode，每一个HeroNode对象就是一个节点
class HeroNode {
    public int number;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int number, String name, String nickName) {
        this.number = number;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}


