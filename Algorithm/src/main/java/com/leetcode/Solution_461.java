package com.leetcode;

public class Solution_461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int ans = 0;
        while (num > 0) {
            num -= lowBit(num);
            ans++;
        }
        return ans;
    }

    private int lowBit(int i) {
        return i & -i;
    }
}

