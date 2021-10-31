package com.leetcode.offer;

public class Solution_15 {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}
