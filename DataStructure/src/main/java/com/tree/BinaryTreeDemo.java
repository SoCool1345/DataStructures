package com.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        BinaryTreeNode node1=new BinaryTreeNode(1,"abc");
        BinaryTreeNode node2=new BinaryTreeNode(2,"bcd");
        BinaryTreeNode node3=new BinaryTreeNode(3,"cde");
        BinaryTreeNode node4=new BinaryTreeNode(4,"def");
        BinaryTreeNode node5=new BinaryTreeNode(5,"efg");
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
//        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
        System.out.println("前序");
        System.out.println(binaryTree.preSearch(5));
        System.out.println("中序");
        System.out.println(binaryTree.infixSearch(5));
        System.out.println("后序");
        System.out.println(binaryTree.postSearch(5));
    }


}
