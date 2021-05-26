package com.leetcode;

public class Solution_7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int lastInt = x % 10;
            x = x / 10;
            if (Math.abs(ans) > Integer.MAX_VALUE / 10) return 0;
            if (Math.abs(ans) == Integer.MAX_VALUE / 10 && (lastInt > 7 || lastInt < -8)) return 0;
            ans = ans * 10 + lastInt;
        }
        return ans;
    }
}
