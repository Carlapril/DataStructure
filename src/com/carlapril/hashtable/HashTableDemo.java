package com.carlapril.hashtable;

import com.sun.source.tree.CaseTree;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * @author carlapril
 * @create 2020-10-06 16:48
 */
public class HashTableDemo {
    public static void main(String[] args) {
        //菜单
        HashTable hashTable = new HashTable(6);
        String text = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:添加雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            text = scanner.next();
            switch (text) {
                case "add":
                    System.out.println("请输入ID");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    System.out.println("请输入部门");
                    String departmentName = scanner.next();
                    Employee employee = new Employee(id, name, departmentName);
                    hashTable.add(employee);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入雇员ID");
                    int employeeId = scanner.nextInt();
                    hashTable.findEmpById(employeeId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    break;

            }

        }

    }
}

class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size = 6;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }


    }

    public void add(Employee employee) {//根据部门名称添加到对应链表
        int number = hashFunction(employee.departmentName);
        System.out.println("获取链表序号" + number + "，" + "部门为：" + employee.departmentName);
        empLinkedListArray[number].addEmp(employee);
//        System.out.println("雇员添加成功");

    }

    //遍历所有的链表
    public void list() {
        for (int i = 0; i < size; i++) {
//            empLinkedListArray[i].list(i);
            switch (i) {
                case 0:
                    System.out.println("人力资源部门：");
                    empLinkedListArray[0].list();
                    break;
                case 1:
                    System.out.println("化学部门：");
                    empLinkedListArray[1].list();
                    break;
                case 2:
                    System.out.println("生物部门：");
                    empLinkedListArray[2].list();
                    break;
                case 3:
                    System.out.println("新药服务部门");
                    empLinkedListArray[3].list();
                    break;
                case 4:
                    System.out.println("临床实验部门：");
                    empLinkedListArray[4].list();
                    break;
                case 5:
                    System.out.println("生产部门：");
                    empLinkedListArray[5].list();
                    break;
                default:
                    break;
            }
        }
    }
    public void findEmpById(int id){
        for (int i = 0; i < size; i++) {
            Employee employee = empLinkedListArray[i].findEmpById(id);
            if (employee!= null){
                System.out.println(employee);
                return;
            }
        }
        System.out.println("未找到该雇员");
    }

    public int hashFunction(String departmentName) {//根部部门名称返回对应数字
        switch (departmentName) {
            case "人力资源部门":
                return 0;
            case "化学部门":
                return 1;
            case "生物部门":
                return 2;
            case "新药服务部门":
                return 3;
            case "临床实验部门":
                return 4;
            case "生产部门":
                return 5;
        }
        System.out.println("输入部门有误");
        return -1;
    }

}

class Employee {
    public int id;
    public String name;
    public String departmentName;
    public Employee next;

    public Employee(int id, String name, String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}

class EmpLinkedList {
    private Employee head;

    public void addEmp(Employee employee) {//添加雇员
        if (head == null) {
            head = employee;
            System.out.println("雇员添加成功");
            return;
        }//如果不是第一个员工
        Employee tempEmp = head;
//        System.out.println("tempEmp = " + tempEmp);
        while (true) {
            if (tempEmp.next == null) {
                break;
            }
            tempEmp = tempEmp.next;//向后找
        }
        tempEmp.next = employee;
        System.out.println("雇员添加成功");
    }

    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        System.out.println("链表信息为：");
        Employee tempEmp = head;
        while (true) {
            System.out.print("=>ID和姓名为：" + tempEmp.id + "  " + tempEmp.name);
            if (tempEmp.next == null) {
                break;
            }
            tempEmp = tempEmp.next;
        }
        System.out.println();
    }

    public Employee findEmpById(int id) {//根据ID查找雇员
        if (head == null) {
//            System.out.println("链表空");
            return null;
        }
        Employee tempEmp = head;
        while (true) {
            if (tempEmp.id == id) {
                break;
            }
            tempEmp = tempEmp.next;
            if (tempEmp == null) {
                tempEmp = null;
                break;
            }
        }
        return tempEmp;
    }
}
