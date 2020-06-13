package com.tree;

public class ThreadedBinaryTree {
    ThreadedBinaryTreeNode root;
    ThreadedBinaryTreeNode pre;//前驱结点

    public ThreadedBinaryTree(ThreadedBinaryTreeNode root) {
        this.root = root;
    }

    public ThreadedBinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedBinaryTreeNode root) {
        this.root = root;
    }

    public ThreadedBinaryTreeNode getPre() {
        return pre;
    }

    public void setPre(ThreadedBinaryTreeNode pre) {
        this.pre = pre;
    }
    public void preThreaded(){
        this.preThreaded(root);
    }
    public void infixThreaded(){
        this.infixThreaded(root);
    }

    //前序线索化
    public void preThreaded(ThreadedBinaryTreeNode node){
        if(node==null){
            return;
        }
        //当前节点线索化
        //左指针
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //右指针
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        //左子树线索化
        if(node.getLeftType()!=1) {
            preThreaded(node.getLeft());
        }

        //右子树线索化
        if(node.getRightType()!=1) {
            preThreaded(node.getRight());
        }
    }
    //中序线索化
    public void infixThreaded(ThreadedBinaryTreeNode node){
        if(node==null){
            return;
        }
        //左子树线索化
        infixThreaded(node.getLeft());
        //当前节点线索化
        //左指针
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //右指针
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        //右子树线索化
        infixThreaded(node.getRight());
    }
    //前序遍历
    public void preThreadedList(){
        ThreadedBinaryTreeNode node=root;
        while (true) {
            if (node == null) {
                break;
            }

            while (node.getLeftType() == 0) {//一直向左遍历直到没有子树
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            node = node.getRight();
        }
    }
    //中序遍历
    public void infixThreadedList(){
        ThreadedBinaryTreeNode node=root;
        while (true) {
            if (node == null) {
                break;
            }

            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}
