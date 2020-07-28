package com.dac;

import java.util.HashSet;
import java.util.Set;

public class Bag01 {
    public static void main(String[] args) {
        int n=5;
        int m=10;
        Set<Integer> set=new HashSet<Integer>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        System.out.println(set.contains(2));
        int f[]=new int[m+1];
        int v[]=new int[]{0,1,3,2,7,5};
        int w[]=new int[]{0,1,2,2,4,3};
        for (int i = 1; i <=n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j]=Math.max(f[j],f[j-v[i]]+w[i]);

            }
        }


        System.out.println(f[m]);

    }
}
