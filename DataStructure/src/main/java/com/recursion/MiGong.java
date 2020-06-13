package com.recursion;

import org.junit.Test;

public class MiGong {
    @Test
    public void test(){
        int[][] map=new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[4][1]=1;
        map[5][2]=1;
        for (int i = 0; i < 8; i++) {
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,3,2);
        for (int i = 0; i < 8; i++) {
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 下-右-上-左 1--墙 2--通 3--不通
     * @param map 表示地图
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int [][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){//当前这个点还没有走过
                map[i][j]=2;//假定可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }


        }
    }

}
