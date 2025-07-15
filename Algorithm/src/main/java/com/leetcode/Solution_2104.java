package com.leetcode;

public class Solution_2104 {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = nums[i], min = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max,nums[j]);
                min = Math.min(min, nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }
}
