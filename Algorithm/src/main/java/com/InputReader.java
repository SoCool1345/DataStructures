package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class InputReader {
    BufferedReader buf;
    StringTokenizer tok;

    InputReader() {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }

    boolean hasNext() {
        while (tok == null || !tok.hasMoreElements()) {
            try {
                tok = new StringTokenizer(buf.readLine());
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    String next() {
        if (hasNext()) return tok.nextToken();
        return null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);

        Scanner cin = null;
        char x = (char) cin.nextInt();
    }
}

class Solution {
    static int res = Integer.MAX_VALUE;

    static public int getLengthOfOptimalCompression(String s, int k) {
        dfs(s, 0, 0, k);
        return res;
    }

    static void dfs(String s, int index, int length, int k) {
        if (index >= s.length()) {
            res = Math.min(res, length);
        }
        if (length >= res) return;
        int len = 1;
        char a = s.charAt(index);
        for (int i = 0; i <= k; i++) {
            if (index >= 2 && s.charAt(index - 1) == s.charAt(index) && s.charAt(index - 2) == s.charAt(index - 1))
                len = 0;
//             for(int j=index;j<s.length();j++){

//             }
            //System.out.print(length);
            if (i == 0) dfs(s, index + 1, length + len, k);
            else
                dfs(s, index + i + 1, length, k - i);

        }
    }

    public static void main(String[] args) {
        getLengthOfOptimalCompression("aaabcccd", 2);
//        ArrayDeque;
//        TreeSet;
//        BitSet;
//        Math.


    }
}

class Main {
    final static int N = 100010;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
    }
}
class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}