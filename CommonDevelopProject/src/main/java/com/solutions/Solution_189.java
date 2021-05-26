package com.solutions;

public class Solution_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        int i = 0;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) exchange(nums, i++, j--);
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
