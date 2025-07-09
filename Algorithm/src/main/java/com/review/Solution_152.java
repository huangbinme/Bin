package com.review;

public class Solution_152 {
    public int maxProduct(int[] nums) {
        int ans = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            int newMin = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            ans = Math.max(ans, newMax);
            min = newMin;
            max = newMax;
        }
        return ans;
    }
}
