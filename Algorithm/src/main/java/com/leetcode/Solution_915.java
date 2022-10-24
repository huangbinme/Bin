package com.leetcode;

public class Solution_915 {
    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        int max = nums[0];
        min[min.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (max <= min[i + 1]) {
                return i + 1;
            } else {
                max = Math.max(max, nums[i + 1]);
            }
        }
        return -1;
    }
}
