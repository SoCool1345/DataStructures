package com.Kruskal;

import java.util.Arrays;

public class Kruskal {
    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int [][] matrix=new int[vertex.length][vertex.length];
        final int N=Integer.MAX_VALUE;
        matrix[0]=new int[]{0,5,7,N,N,N,2};
        matrix[1]=new int[]{5,0,N,9,N,N,3};
        matrix[2]=new int[]{7,N,0,N,8,N,N};
        matrix[3]=new int[]{N,9,N,0,N,4,N};
        matrix[4]=new int[]{N,N,8,N,0,5,4};
        matrix[5]=new int[]{N,N,N,4,5,0,6};
        matrix[6]=new int[]{2,3,N,N,4,6,0};
        Kruskal kruskal = new Kruskal(vertex, matrix);
        kruskal.show();
        EData[] edges=kruskal.getEdges();
        System.out.println(Arrays.toString(edges));
        kruskal.sortEdges(edges);
        System.out.println(Arrays.toString(edges));
        kruskal.kruskal();

    }

    public Kruskal(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }
    public void show(){
        for (int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }
    public void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length - 1-i; j++) {
                if (edges[j].weight>edges[j+1].weight){
                    EData tmp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=tmp;
                }
            }
        }
    }
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }
    private EData[] getEdges(){
        int index=0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j]!=INF){
                    edges[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }
    private int getEnd(int[] ends,int i){
        while (ends[i]!=0) {
            i=ends[i];
            return i;
        }
        return i;

    }
    public void kruskal(){
        int index=0;
        int ends[]=new int[edgeNum];
        EData[] rets=new EData[edgeNum];
        EData[] edges=getEdges();
        sortEdges(edges);
        for (int i = 0; i < edgeNum; i++) {
            int p1=getPosition(edges[i].start);
            int p2=getPosition(edges[i].end);
            int m=getEnd(ends,p1);
            int n=getEnd(ends,p2);
            if (m!=n){//不构成回路
                ends[m]=n;
                rets[index++]=edges[i];
            }
        }
        System.out.println("最小生成树"+Arrays.toString(rets));

    }

}
class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

}
