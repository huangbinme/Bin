package com.leetcode;

public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!(s >= 2 && nums[s - 2] == nums[i])) {
                swap(nums, s, i);
                s++;
            }
        }
        return s;
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
