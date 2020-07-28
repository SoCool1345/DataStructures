package com.graph;
//检测图中是否有环
public class DirectedCycle {
    private boolean[] marked;
    private boolean hasCycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        this.marked = new boolean[G.V()];
        this.hasCycle = false;
        this.onStack = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i])
            dfs(G,i);
        }

    }

    private void dfs(Digraph G, int v){
        marked[v]=true;
        onStack[v]=true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
            if(onStack[w]){
                hasCycle=true;
                return;
            }
        }
        onStack[v]=false;
    }
    public boolean hasCycle(){
        return hasCycle;

    }
}
