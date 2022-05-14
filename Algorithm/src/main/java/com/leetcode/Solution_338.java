package com.leetcode;

public class Solution_338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int c = i, count = 0;
            while ((lowBit(c)) != 0) {
                count++;
                c = c ^ lowBit(c);
            }
            ans[i] = count;
        }
        return ans;
    }

    private int lowBit(int i) {
        return i & -i;
    }
}
