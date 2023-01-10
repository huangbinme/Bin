package com.leetcode;

public class Solution_2180 {
    public int countEven(int num) {
        int i = 2, ans = 0;
        while (i <= num) {
            ans += check(i) ? 1 : 0;
            i += 2;
        }
        return ans;
    }

    private boolean check(int num) {
        int c = 0;
        while (num != 0) {
            c += num % 10;
            if (num == 10) {
                num = 1;
            } else if (num < 10) {
                num = 0;
            } else {
                num %= 10;
            }
        }
        return c % 2 == 0;
    }
}
