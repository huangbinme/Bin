package com.solutions;

public class Solution_5717 {
    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                result += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }
}
