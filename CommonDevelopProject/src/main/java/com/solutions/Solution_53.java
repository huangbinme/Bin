package com.solutions;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int maxWithCurrentNum = nums[0];
        int maxWithoutCurrentNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxWithCurrentNum = Math.max(nums[i], nums[i] + maxWithCurrentNum);
            maxWithoutCurrentNum = Math.max(maxWithCurrentNum, maxWithoutCurrentNum);
        }
        return Math.max(maxWithCurrentNum, maxWithoutCurrentNum);
    }
}
