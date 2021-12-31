package com.leetcode;

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        init(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            build(nums, 0, i);
        }
        return nums;
    }

    private void init(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            build(nums, i, nums.length);
        }
    }

    private void build(int[] nums, int start, int size) {
        int r = 2 * start + 1, l = r + 1;
        int largest = start;
        if (r < size && nums[r] > nums[largest]) {
            largest = r;
        }
        if (l < size && nums[l] > nums[largest]) {
            largest = l;
        }
        if (largest != start) {
            swap(nums, largest, start);
            build(nums, largest, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
