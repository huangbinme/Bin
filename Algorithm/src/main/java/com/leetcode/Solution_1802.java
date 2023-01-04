package com.leetcode;

public class Solution_1802 {
    public int maxValue(int n, int index, int maxSum) {
        int curMaxSum = n, l = index, r = index, ans = 1;
        while (curMaxSum <= maxSum) {
            curMaxSum += (r - l + 1);
            if (l > 0) l--;
            if (r < n - 1) r++;
            ans++;
            if (l == 0 && r == n - 1) break;
        }
        if (curMaxSum <= maxSum) {
            ans += (maxSum - curMaxSum) / n + 1;
        }
        return ans - 1;
    }
}
