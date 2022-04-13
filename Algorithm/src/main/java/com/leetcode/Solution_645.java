package com.leetcode;

public class Solution_645 {
    public int[] findErrorNums(int[] nums) {
        int dup = 0, miss = 0;
        for (int num : nums) {
            int i = Math.abs(num) - 1;
            if (nums[i] > 0) {
                nums[i] *= -1;
            } else {
                dup = Math.abs(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        return new int[]{dup, miss};
    }
}
