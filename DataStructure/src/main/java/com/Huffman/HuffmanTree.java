package com.Huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[]={7,13,9,17,15,65};
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);

    }
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else System.out.println("树为空");
    }
    public static Node createHuffmanTree(int[]arr){
        List<Node> nodes=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }
        while (nodes.size()>1) {
            //给集合排序
            Collections.sort(nodes);
            //把前两个node取出为其添加父节点
             Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.no + right.no);
            //把这两个节点挂到父节点上
            parent.leftNode=left;
            parent.rightNode=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);

    }
}
class Node implements Comparable<Node>{
    int no;
    Node leftNode;
    Node rightNode;
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if(this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.no-o.no;
    }

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}