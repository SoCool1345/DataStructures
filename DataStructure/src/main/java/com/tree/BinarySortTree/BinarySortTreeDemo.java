package com.tree.BinarySortTree;

import org.junit.Test;

public class BinarySortTreeDemo {
    @Test
    public void test(){
        BinarySortTree binarySortTree = new BinarySortTree();
        int arr[]={3,1,5,23,12,7,9};
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }

//        binarySortTree.delNode(12);
//        binarySortTree.delNode(5);
//        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(9);
        binarySortTree.delNode(23);
        binarySortTree.infixOrder();
    }
}
