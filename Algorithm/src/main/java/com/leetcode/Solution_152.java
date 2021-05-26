package com.leetcode;

public class Solution_152 {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max_tmp = max;
            int min_tmp = min;
            max = Math.max(Math.max(max_tmp * nums[i], min_tmp * nums[i]), nums[i]);
            min = Math.min(Math.min(max_tmp * nums[i], min_tmp * nums[i]), nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
