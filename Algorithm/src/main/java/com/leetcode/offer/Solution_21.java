package com.leetcode.offer;

public class Solution_21 {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= r) break;
            if (nums[i] % 2 != 0) {
                l++;
            } else {
                while (i < r && nums[i] % 2 == 0) {
                    swap(nums, l, r--);
                }
                l++;
            }
        }
        return nums;
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
