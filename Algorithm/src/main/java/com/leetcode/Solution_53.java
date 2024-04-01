package com.leetcode;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MIN_VALUE, min = 0;
        for (int i = 1; i < preSum.length; i++) {
            ans = Math.max(ans, preSum[i] - min);
            min = Math.min(min, preSum[i]);
        }
        return ans;
    }
}
