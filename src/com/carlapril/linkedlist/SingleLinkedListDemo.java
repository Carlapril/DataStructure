package com.carlapril.linkedlist;

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
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        singleLinkedList.list();


    }
}

    //定义SingleLinkedList管理英雄
    class SingleLinkedList {
        //定义一个头节点，不要动。
        private HeroNode head = new HeroNode(0, "", "");

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


