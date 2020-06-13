package com.tree;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    public void preOrder(){
        if (root != null) {
            root.preOrder();
        } else System.out.println("二叉树为空");
    }

    public void infixOrder(){
        if (root != null) {
            root.infixOrder();
        } else System.out.println("二叉树为空");
    }
    public void postOrder(){
        if (root != null) {
            root.postOrder();
        } else System.out.println("二叉树为空");
    }
    public BinaryTreeNode preSearch(int id){
        if(root!=null){
            return root.preSearch(id);
        }else return null;
    }
    public BinaryTreeNode infixSearch(int id){
        if(root!=null){
            return root.infixSearch(id);
        }else return null;
    }
    public BinaryTreeNode postSearch(int id){
        if(root!=null){
            return root.postSearch(id);
        }else return null;
    }
}
