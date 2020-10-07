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
        binaryTree.preOrder();
        System.out.println("中序遍历：");
        binaryTree.infix();
        System.out.println("后序遍历：");
        binaryTree.postOrder();
        EmployeeNode resNode = binaryTree.preOrderSearch(3);
        System.out.println("resNode = " + resNode);
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

    public EmployeeNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        }
        return null;
    }

    public EmployeeNode postOrderSearch(int id) {
        if (this.root != null) {
            return this.root.postOrderSearch(id);
        }
        return null;
    }

    public EmployeeNode infixSearch(int id) {
        if (this.root != null) {
            return this.root.infixSearch(id);
        }
        return null;
    }
    public void deleteNode(int id){
        if (this.root!=null){
            if (this.root.getId()==id){
                this.root = null;
            }else{
                this.root.deleteNode(id);
            }
        }else{
            System.out.println("空二叉树，无法删除");
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

    //前序查找 依据id
    public EmployeeNode preOrderSearch(int id) {
        if (this.getId() == id) {//比较根节点
            return this;
        }
        EmployeeNode resNode = null;
        if (this.getLeft() != null) {//向左递归查找
            resNode = this.getLeft().preOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getRight() != null) {//向右递归
            resNode = this.getRight().preOrderSearch(id);
        }
        return resNode;
    }

    public EmployeeNode infixSearch(int id) {//按照id中序查找
        EmployeeNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().infixSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getId() == id) {
            return this;
        }
        if (this.getRight() != null) {
            resNode = this.getRight().infixSearch(id);
        }
        return resNode;
    }

    public EmployeeNode postOrderSearch(int id) {//按照id后续查找
        EmployeeNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getRight() != null) {
            resNode = this.getRight().postOrderSearch(id);
        }
        if (this.getId() == id) {
            return this;
        }
        return resNode;
    }

    public void deleteNode(int id) {//递归删除指定节点
        //左子节点不为空才能删除
        if (this.getLeft() != null && this.getLeft().getId() == id) {
            this.setLeft(null);
            return;
        }//右子节点不为空才能删除
        if (this.getRight() != null && this.getRight().getId() == id) {
            this.setRight(null);
            return;
        }
        //向左递归删除
        if (this.getLeft()!= null){
            this.getLeft().deleteNode(id);
        }
        //向右递归删除
        if (this.getRight()!= null){
            this.getRight().deleteNode(id);
        }

    }
}
