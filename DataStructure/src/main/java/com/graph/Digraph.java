package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Digraph {
    private final int V;
    private int E;
    private Queue<Integer>[] adj;

    public Digraph(int v) {
        V = v;
        E = 0;
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new LinkedList<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].offer(w);
        E++;
    }
    public Queue<Integer>adj(int v){
        return adj[v];

    }
    private Digraph reverse(){
        Digraph r=new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer w : adj[i]) {
                r.addEdge(w,i);
            }
        }
        return r;
    }
}
