package com.leetcode.offer;

public class Solution_61 {
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] note = new int[14];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
                note[nums[i]]++;
                if (note[nums[i]] > 1) {
                    return false;
                }
            }
        }
        return max - min <= 4;
    }
}
