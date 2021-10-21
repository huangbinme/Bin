package com.leetcode;

public class Solution_453 {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (nums[i] - min);
        }
        return ans;
    }
}
