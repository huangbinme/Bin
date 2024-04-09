package com.leetcode;

public class Solution_2529 {
    public int maximumCount(int[] nums) {
        int c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) c1++;
            if(nums[i] > 0) c2++;
        }
        return Math.max(c1, c2);
    }
}
