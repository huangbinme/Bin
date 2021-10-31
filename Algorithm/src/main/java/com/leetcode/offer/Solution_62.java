package com.leetcode.offer;

public class Solution_62 {
    public int lastRemaining(int n, int m) {
        int ans = 0, size = 2;
        for (int i = 0; i < n - 1; i++) {
            ans = (ans + m) % size;
            size++;
        }
        return ans;
    }
}
