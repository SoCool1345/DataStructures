package com.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartSort {
    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode temp = head;
            if (temp == null) {
                return null;
            }
            if (temp.next == null) {
                return head;
            }
            ListNode secondNode = temp.next;
            temp.next = temp.next.next;
            temp.next.next = temp;
            swapPairs(temp.next);
            return secondNode;

        }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if (numRows == 0) {
                return result;
            }
            if (numRows == 1) {
                result.add(new ArrayList<>());
                result.get(0).add(1);
                return result;
            }
            result = generate(numRows - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i < numRows - 1; i++) {

                row.add(result.get(numRows - 2).get(i - 1) + result.get(numRows - 2).get(i));
            }
            row.add(1);
            result.add(row);
            return result;

        }

        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            if (rowIndex == 0) {
                return result;
            }
            if (rowIndex == 1) {
                result.add(1);
                return result;
            }
            result = getRow(rowIndex - 1);
            List<Integer> sub = new ArrayList<>();
            sub.add(1);
            for (int i = 1; i < rowIndex - 1; i++) {

                sub.add(result.get(i - 1) + result.get(i));
            }
            sub.add(1);

            return sub;

        }
    }

    public int fib(int N) {
        Map<Integer, Integer> cache = new HashMap<>();
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if (N < 2) {
            return N;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, result);
        return result;

    }




}
