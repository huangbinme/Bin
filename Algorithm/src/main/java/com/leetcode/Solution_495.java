package com.leetcode;

public class Solution_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0, k = -1;
        for (int i = 0; i < timeSeries.length; i++) {
            int n = timeSeries[i] + duration;
            if (k < n) {
                ans += k < i ? duration : n - k;
                k = n;
            }
        }
        return ans;
    }
}
