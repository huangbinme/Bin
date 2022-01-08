package com.leetcode.offer;

public class Solution_14 {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int ans = 1;
        while (n >= 3) {
            ans *= 3;
            n -= 3;
        }
        if (n == 2) ans *= 2;
        if (n == 1) {
            ans /= 3;
            ans *= 4;
        }
        return ans;
    }
}
