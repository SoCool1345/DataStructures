package com.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTreeNode node1=new ThreadedBinaryTreeNode(1,"abc");
        ThreadedBinaryTreeNode node2=new ThreadedBinaryTreeNode(2,"bcd");
        ThreadedBinaryTreeNode node3=new ThreadedBinaryTreeNode(3,"cde");
        ThreadedBinaryTreeNode node4=new ThreadedBinaryTreeNode(4,"def");
        ThreadedBinaryTreeNode node5=new ThreadedBinaryTreeNode(5,"efg");
        ThreadedBinaryTree binaryTree=new ThreadedBinaryTree(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
//        binaryTree.infixThreaded();
//        System.out.println(node5.getLeft().getId());
//        System.out.println(node5.getRight().getId());
//        System.out.println(node2.getLeftType());
//        binaryTree.infixThreadedList();
        binaryTree.preThreaded();
        System.out.println(node5.getLeft().getId());

    }

}
