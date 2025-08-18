package com.review;

public class Solution_7 {
    public int reverse(int x) {
        if (x == 0) return 0;
        boolean positive = x > 0;
        int ans = 0;
        x = Math.abs(x);
        while (x != 0) {
            int appendNum = x % 10;
            x /= 10;
            if (outOfBounds(ans, appendNum, positive)) return 0;
            ans *= 10;
            ans += appendNum;
        }
        return ans * (positive ? 1 : -1);
    }

    public boolean outOfBounds(int i, int j, boolean positive) {
        if (positive) {
            return i * 10 < 0 || i > 214748364 || (i == 214748364 && j > 7);
        } else {
            return i * 10 < 0 || i > 214748364 || (i == 214748364 && j > 8);
        }
    }
}