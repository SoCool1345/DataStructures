package com.graph;

import java.util.Stack;

public class DepthFirstOrder {
    private boolean[]marked;
    private Stack<Integer> reverserPost;

    public DepthFirstOrder(Digraph G) {
        this.marked = new boolean[G.V()];
        this.reverserPost = new Stack<Integer>();
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i])
            dfs(G,i);
        }
    }
    public void dfs(Digraph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if (!marked[w])
                dfs(G,w);
        }
        reverserPost.push(v);
    }

    public Stack<Integer> getReverserPost() {
        return reverserPost;
    }
}
