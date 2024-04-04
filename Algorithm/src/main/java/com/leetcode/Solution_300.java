package com.leetcode;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = Math.max(1, max);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
