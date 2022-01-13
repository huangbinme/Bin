package com.leetcode;

public class Solution_747 {
    public int dominantIndex(int[] nums) {
        int max = nums[0], index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max && max < nums[i] * 2) return -1;
        }
        return index;
    }
}
