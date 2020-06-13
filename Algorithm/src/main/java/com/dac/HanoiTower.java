package com.dac;

public class HanoiTower {
    public static void main(String[] args) {
        int num=3;
        char a='A';
        char b='B';
        char c='C';
        hanoiTower(num,a,b,c);
    }
    public static void hanoiTower(int num,char a,char b,char c){
        if(num==1){
            System.out.println(a+"->"+c);
        }else {
            hanoiTower(num - 1, a, c, b);
            System.out.println(a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
