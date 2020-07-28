package com;

import java.util.Arrays;

public class Dijks {
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int [][] matrix=new int[vertex.length][vertex.length];
        final int N=65535;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex, matrix);
        graph.show();
        graph.dsj(6);


    }
}
class Graph{
    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }
    public void show(){
        for (int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }
    /**
     *
     * @param index 出发点
     */
    public void dsj(int index){

        vv = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱
        for (int j = 1; j < vertex.length; j++) {
            index=vv.updateArr();
            update(index);
        }
        vv.show();

    }
    private void update(int index){
        int len;
        for (int i = 0; i < matrix[index].length; i++) {
            len=vv.getDis(index)+matrix[index][i];
            if (!vv.isVisited(i)&&len<vv.getDis(i)){
                vv.updatePre(i,index);
                vv.updateDis(i,len);

            }
        }

    }

}
class VisitedVertex{
    public int[] already_arr;
    public  int[] pre_visited;
    public int[] dis;

    public VisitedVertex(int length,int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis,65535);
        this.already_arr[index]=1;
        dis[index]=0;

    }
    public boolean isVisited(int index){
        return already_arr[index]==1;
    }

    /**
     * 出发顶点到index的距离
     * @param index
     * @param len
     */
    public void updateDis(int index,int len){
        dis[index]=len;
    }
    //更新pre顶点的前驱为index节点
    public void updatePre(int Pre,int index){
        pre_visited[Pre]=index;
    }
    //返回出发点到index的距离
    public int getDis(int index){
        return dis[index];
    }
    public int updateArr(){
        int min=65535;
        int index=0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i]==0&&dis[i]<min){
                min=dis[i];
                index=i;
            }

        }
        already_arr[index]=1;
        return index;
    }
    public void show(){
        System.out.println("=================");
        System.out.println("已经访问过的节点"+Arrays.toString(already_arr));
        System.out.println("=================");
        System.out.println("最短距离"+Arrays.toString(dis));
        System.out.println("=================");
        System.out.println("前驱"+Arrays.toString(pre_visited));
    }









}