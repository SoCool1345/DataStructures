package com.tree;



public class BinaryTreeNode {
    private int id;
    private String name;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int id, String name) {
        this.id = id;
        this.name = name;
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

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //遍历
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }

        if(this.right!=null){
            this.right.postOrder();
        }

        System.out.println(this);
    }
    //查找
    //前序查找
    public BinaryTreeNode preSearch(int id){
        System.out.println("--");
        if(this.id==id){
            return this;
        }

        BinaryTreeNode node=null;
        if(this.left!=null){
            node=this.left.preSearch(id);
        }
        if(node!=null){
            return node;
        }
        if(this.right!=null){
            node=this.right.preSearch(id);
        }
        return node;

    }
    //中序查找
    public BinaryTreeNode infixSearch(int id){

        BinaryTreeNode node=null;
        if(this.left!=null){
            node=this.left.infixSearch(id);
        }
        if(node!=null){
            return node;
        }
        System.out.println("--");
        if(this.id==id){
            return this;
        }
        if(this.right!=null){
            node=this.right.infixSearch(id);
        }
        return node;
    }
    //后序查找
    public BinaryTreeNode postSearch(int id){
        BinaryTreeNode node=null;
        if(this.left!=null){
            node=this.left.postSearch(id);
        }
        if(node!=null){
            return node;
        }
        if(this.right!=null){
            node=this.right.postSearch(id);
        }
        if(node!=null){
            return node;
        }
        System.out.println("--");
        if(this.id==id){
            return this;
        }
        return node;
    }
}
