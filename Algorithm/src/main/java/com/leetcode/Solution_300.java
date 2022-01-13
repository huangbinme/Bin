package com.leetcode;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int dpIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = 0, r = dpIndex;
            while (l < r) {
                int m = (r - l) / 2 + l;
                if (dp[m] < nums[i]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp[l] = nums[i];
            if (l == dpIndex) dpIndex++;
        }
        return dpIndex;
    }


}
