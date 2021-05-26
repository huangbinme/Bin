package com.solutions;

public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int newArrayLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[newArrayLength - 1]) {
                continue;
            }
            nums[newArrayLength++] = nums[i];
        }
        return newArrayLength;
    }
}
