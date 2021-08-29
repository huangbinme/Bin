package com.leetcode;

public class Solution_1646 {
    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] ints = new int[n + 1];
        ints[1] = 1;
        int ans = 1;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = i % 2 == 0 ? ints[i / 2] : ints[i / 2] + ints[i / 2 + 1];
            ans = Math.max(ans, ints[i]);
        }
        return ans;
    }
}
