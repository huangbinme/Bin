package com.leetcode;

public class Solution_334 {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = 0, r = ans;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (dp[mid] < nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            dp[l] = nums[i];
            if (ans == r) ans++;
        }
        return ans >= 3;
    }
}
