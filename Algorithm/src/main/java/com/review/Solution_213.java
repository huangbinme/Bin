package com.review;

public class Solution_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int a = 0, b = 0;
        for (int i = start; i < end; i++) {
            int tmpA = a, tmpB = b;
            a = nums[i] + tmpB;
            b = Math.max(tmpA, tmpB);
        }
        return Math.max(a, b);
    }
}
