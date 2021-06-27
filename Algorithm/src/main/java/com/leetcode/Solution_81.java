package com.leetcode;

public class Solution_81 {
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
