package com.leetcode;

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i], target = i - 1;
            while (target >= 0 && nums[target] > tmp) {
                nums[target + 1] = nums[target];
                target--;
            }
            nums[target + 1] = tmp;
        }
        return nums;
    }
}
