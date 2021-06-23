package com.leetcode.offer;

public class Solution_15 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += Math.abs(n % 2);
            n = n >> 1;
        }
        return ans;
    }
}
