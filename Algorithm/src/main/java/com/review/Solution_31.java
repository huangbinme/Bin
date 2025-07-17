package com.review;

import java.util.Arrays;

public class Solution_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        boolean sort = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                sort = true;
                int j = getSwap(nums, nums[i]);
                swap(nums, i, j);
                Arrays.sort(nums, i + 1, nums.length);
                break;
            }
        }
        if (!sort) Arrays.sort(nums);
    }

    private int getSwap(int[] nums, int num) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > num) return i;
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
