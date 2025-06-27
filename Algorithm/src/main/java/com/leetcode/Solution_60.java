package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_60 {

    int loopCount = 0;

    String ans = "";

    public String getPermutation(int n, int k) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i + 1;
        }
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visit = new boolean[n];
        dfs(ints, visit, deque, k);
        return ans;
    }

    private void dfs(int[] ints, boolean[] visit, Deque<Integer> deque, int k) {
        if (ans.length() != 0) return;
        if (deque.size() == ints.length) {
            loopCount++;
            if (loopCount == k) {
                while (!deque.isEmpty()) {
                    ans = ans + deque.pollFirst();
                }
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            deque.offerLast(ints[i]);
            dfs(ints, visit, deque, k);
            visit[i] = false;
            deque.pollLast();
        }
    }
}
