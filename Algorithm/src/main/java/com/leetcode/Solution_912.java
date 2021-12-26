package com.leetcode;

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        for (int i = nums.length / 2; i >= 1; i /= 2) {
            for (int j = 0; j < i; j++) {
                for (int k = j + i; k < nums.length; k += i) {
                    for (int l = k; l - i >= 0 && nums[l - i] > nums[l]; l -= i) {
                        swap(nums, l - i, l);
                    }
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
