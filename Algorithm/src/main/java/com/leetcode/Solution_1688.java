package com.leetcode;

public class Solution_1688 {
    public int numberOfMatches(int n) {
        int ans = 0;
        while (n != 0 && n != 1) {
            ans += n / 2;
            n = (n / 2 + n % 2);
        }
        return ans;
    }
}
