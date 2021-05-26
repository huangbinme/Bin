package com.leetcode;

public class Solution_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        boolean needReverse = true;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                needReverse = false;
                processing(nums, i);
                break;
            }
        }
        if (needReverse) reverse(nums, 0, nums.length - 1);
    }

    private void processing(int[] nums, int index) {
        reverse(nums, index, nums.length - 1);
        int loopIndex = index;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > nums[index - 1]) {
                exchange(nums, i, index - 1);
                loopIndex = i;
                break;
            }
        }
        for (int i = loopIndex; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) break;
            exchange(nums, i, i + 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) exchange(nums, start++, end--);
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
