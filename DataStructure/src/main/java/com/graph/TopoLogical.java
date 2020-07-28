package com.graph;

import java.util.Stack;

public class TopoLogical {
    private Stack<Integer> order;

    public TopoLogical(Digraph G) {
        DirectedCycle cycle=new DirectedCycle(G);
        if(!cycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            this.order = depthFirstOrder.getReverserPost();
        }

    }
    private boolean isCycle(){
        return order==null;
    }

    public Stack<Integer> getOrder() {
        return order;
    }
}
