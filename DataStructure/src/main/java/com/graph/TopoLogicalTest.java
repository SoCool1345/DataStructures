package com.graph;

import java.util.Stack;

public class TopoLogicalTest {
    public static void main(String[] args) {
        Digraph digraph=new Digraph(6);
        digraph.addEdge(0,2);
        digraph.addEdge(0,3);
        digraph.addEdge(2,4);
        digraph.addEdge(3,4);
        digraph.addEdge(4,5);
        digraph.addEdge(1,3);
        TopoLogical topoLogical = new TopoLogical(digraph);
        Stack<Integer> order = topoLogical.getOrder();
        for (Integer w : order) {
            System.out.print(w+"->");
        }
    }
}
