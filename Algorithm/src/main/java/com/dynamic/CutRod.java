package com.dynamic;

public class CutRod {
    public static void main(String[] args) {
        int p[]={1,5,8,9,10,17,17,20,24,30};
        System.out.println(cutRod(p, 9));
    }

    /**
     *
     * @param p i英寸价格
     * @param n 钢条长度
     * @return
     */
    public static int cutRod(int[] p,int n){
        int r[]=new int[n+1];
        int q;//第i-j
        r[0]=0;
        for (int i = 1; i <= n; i++) {
            q=0;
            for (int j = 1; j <= i; j++) {
                q=Math.max(q,p[j-1]+r[i-j]);
            }
            r[i]=q;
        }
        return r[n];
    }
}
