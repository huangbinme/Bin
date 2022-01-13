package com.leetcode;

public class Solution_643 {
    public double findMaxAverage(int[] nums, int k) {
        double ans, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ans = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            ans = Math.max(ans, sum / k);
        }
        return ans;
    }
}
