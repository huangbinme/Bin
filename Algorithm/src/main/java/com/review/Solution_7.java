package com.review;

public class Solution_7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && last > 7)) return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && last < -8)) return 0;
            ans *= 10;
            ans += last;
        }
        return ans;
    }
}