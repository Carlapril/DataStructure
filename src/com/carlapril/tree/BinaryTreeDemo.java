package com.carlapril.tree;

/**
 * @author carlapril
 * @create 2020-10-07 14:03
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        EmployeeNode employeeNode = new EmployeeNode(2, "小张");
        EmployeeNode employeeNode1 = new EmployeeNode(1, "小王");
        EmployeeNode employeeNode2 = new EmployeeNode(3, "小李");
        EmployeeNode employeeNode3 = new EmployeeNode(4, "小雷");
        EmployeeNode employeeNode4 = new EmployeeNode(5, "小贾");
        EmployeeNode employeeNode5 = new EmployeeNode(6, "小飞");
        EmployeeNode employeeNode6 = new EmployeeNode(7, "小田");
        employeeNode.setLeft(employeeNode1);
        employeeNode.setRight(employeeNode2);
        employeeNode2.setRight(employeeNode3);
        employeeNode1.setRight(employeeNode4);
        employeeNode1.setLeft(employeeNode5);
        employeeNode5.setRight(employeeNode6);
        binaryTree.setRoot(employeeNode);
        System.out.println("前序遍历:");
        binaryTree.postOrder();

    }
}

class BinaryTree {
    private EmployeeNode root;

    public void setRoot(EmployeeNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infix() {
        if (this.root != null) {
            this.root.infix();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }


}

class EmployeeNode {
    private int id;
    private String name;
    private EmployeeNode left;
    private EmployeeNode right;

    public EmployeeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EmployeeNode() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public EmployeeNode getLeft() {
        return left;
    }

    public void setLeft(EmployeeNode left) {
        this.left = left;
    }

    public EmployeeNode getRight() {
        return right;
    }

    public void setRight(EmployeeNode right) {
        this.right = right;
    }

    //二叉树前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().preOrder();
        }
        if (this.getRight() != null) {
            this.getRight().preOrder();
        }
    }

    //二叉树中序遍历
    public void infix() {
        if (this.getLeft() != null) {
            this.getLeft().infix();
        }
        System.out.println(this);
        if (this.getRight() != null) {
            this.getRight().infix();
        }
    }

    //二叉树的后序遍历
    public void postOrder() {
        if (this.getLeft() != null) {
            this.getLeft().postOrder();
        }
        if (this.getRight() != null) {
            this.getRight().postOrder();
        }
        System.out.println(this);
    }
}
