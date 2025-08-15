package com.review;

public class Solution_26 {

    public int removeDuplicates(int[] nums) {
        int end = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[end - 1]) {
                swap(nums, i, end);
                end++;
            }
        }
        return end;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
