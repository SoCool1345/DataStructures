package com.tree;

public class RedBlackTree  {
    private Node root;
    private int N;
    private final static boolean RED=true;
    private final static boolean BLACK=true;
    class Node{
        public int key;
        public int value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(int key, int value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x==null){
            return false;
        }
        return x.color==RED;
    }
    private Node rotateLeft(Node h){
        Node x=h.right;

        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        return x;

    }
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }
    private void flipColors(Node h){
        h.left.color=BLACK;
        h.right.color=BLACK;
        h.color=RED;
    }
    public void put(int key,int val){
        root=put(root,key,val);
        root.color=BLACK;
    }
    private Node put(Node h,int key,int val){
        if(h==null){
            return new Node(key,val,null,null,RED);
        }
        int cmp=root.key-key;
        if (cmp>0){//向左
            h.left=put(h.left,key,val);
        }else if(cmp<0){
            h.right=put(h.right,key,val);
        }else {
            h.value=val;
        }
        if(isRed(h.right)&&!isRed(h.left)){
            rotateLeft(h);
        }
        if (isRed(h.left)&&isRed(h.left.left)){
            rotateRight(h);
        }
        if(isRed(h.left)&&isRed(h.right)){
            flipColors(h);
        }
        return h;
    }
    public int get(int key){
        return get(root,key);
    }
    private int get(Node x,int key){
        if(x==null){
            return -1;
        }
        int cmp=x.key-key;
        if (cmp>0){
            get(x.left,key);
        }else if(cmp<0){
            get(x.right,key);
        }else return x.value;
        return -1;
    }
    public int size(){
        return N;
    }


}
