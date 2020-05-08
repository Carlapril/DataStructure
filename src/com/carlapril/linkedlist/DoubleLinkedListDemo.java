package com.carlapril.linkedlist;

import java.util.LinkedList;

/**
 * @author carlapril
 * @create 2020-05-08 19:59
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试双向链表
        //创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();//创建链表
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();
        //测试删除
        doubleLinkedList.delete(3);
        System.out.println();
        doubleLinkedList.list();
        //测试插入
        HeroNode2 heroNode5 = new HeroNode2(3,"公孙胜","入云龙");
        doubleLinkedList.addByOrder(heroNode5);
        System.out.println();
        doubleLinkedList.list();



    }

}


class DoubleLinkedList {
    //定义一个头节点，不要动。
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点的方法
    public HeroNode2 getHead() {
        return head;

    }

    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;//一定要重新赋值，不然死循环
        }
    }
    //添加节点到双向链表
    public void add(HeroNode2 heroNode) {
        //先用临时节点找到头，遍历
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //加入一个新方法，将对象插入到指定节点
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
            heroNode.next = temp.next;//先将temp下一个赋给新英雄的下一个节点
             temp.next = heroNode;
            heroNode.pre = temp;

        }
    }
    //修改双向链表
    public void update(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //先定义一个辅助变量
        HeroNode2 temp = head.next;
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
        HeroNode2 temp = head;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.number == number) {
                flag = true;//证明我们找到了该编号的英雄，把flag至真
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("输入的序号有误，请确认是否有该编号英雄！！");
        }

    }
}
class HeroNode2 {
    public int number;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int number, String name, String nickName) {
        this.number = number;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}