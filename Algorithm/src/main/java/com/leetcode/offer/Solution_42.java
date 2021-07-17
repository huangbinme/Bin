package com.leetcode.offer;

public class Solution_42 {
    public int maxSubArray(int[] nums) {
        int preSum = 0, ans = nums[0], minPreSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            ans = Math.max(ans, preSum - minPreSum);
            minPreSum = Math.min(minPreSum,preSum);
        }
        return ans;
    }
}
