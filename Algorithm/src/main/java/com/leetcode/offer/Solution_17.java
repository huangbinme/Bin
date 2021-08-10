package com.leetcode.offer;

public class Solution_17 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] ans = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
