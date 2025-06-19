package com.review;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        //动态规划实现
        int ans = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        //前缀和实现
        int[] preSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 1; i < preSum.length; i++) {
            sum += nums[i - 1];
            preSum[i] = sum;
        }
        int ans = Integer.MIN_VALUE, min = 0;
        for (int i = 1; i < preSum.length; i++) {
            ans = Math.max(ans, preSum[i] - min);
            min = Math.min(min, preSum[i]);
        }
        return ans;
    }
}
