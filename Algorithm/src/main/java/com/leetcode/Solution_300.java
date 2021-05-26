package com.leetcode;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int nodeMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    nodeMax = Math.max(nodeMax, dp[j] + 1);
                }
            }
            dp[i] = nodeMax;
            max = Math.max(max, nodeMax);
        }
        return max;
    }


}
