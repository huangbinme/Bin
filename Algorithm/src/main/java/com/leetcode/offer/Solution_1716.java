package com.leetcode.offer;

public class Solution_1716 {
    public int totalMoney(int n) {
        int ans = 0, week = n / 7;
        ans += (28 * week + week * (week - 1) / 2 * 7);
        int start = week + 1;
        n = n % 7;
        ans += (start * n + n * (n - 1) / 2);
        return ans;
    }
}
