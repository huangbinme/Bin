package com.solutions;

public class Solution_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int dp_rec_1 = nums[start];
        int dp_rec_2 = 0;
        for (int i = start + 1; i < end; i++) {
            int dp_rec_1_tmp = dp_rec_1;
            dp_rec_1 = dp_rec_2 + nums[i];
            dp_rec_2 = Math.max(dp_rec_2, dp_rec_1_tmp);
        }
        return Math.max(dp_rec_1, dp_rec_2);
    }
}
