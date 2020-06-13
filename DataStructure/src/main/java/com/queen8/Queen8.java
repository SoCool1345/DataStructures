package com.queen8;

public class Queen8 {
    static int count=0;
    int max=8;
    int array[]=new int[max];
    public static void main(String[] args) {
        Queen8 queen8 =new Queen8();
        queen8.check(0);
        System.out.println("有"+count+"种摆放方式");
    }
    //摆放N个皇后
    public void check(int n){
        if (n==max){//n等于8说明遍历完了
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n]=i;
            if(judge(n)){//摆放符合条件
                check(n+1);
            }
            //如果冲突，将第n个皇后后移一个位置

        }

    }
    //判断皇后是否摆放冲突
    public Boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //在同一列或斜率为1
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i]))
                return false;
        }
        return true;
    }
    //打印结果
    public void print(){
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
        count++;
    }
}
