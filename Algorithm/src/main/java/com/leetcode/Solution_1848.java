package com.leetcode;

public class Solution_1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (abs > Math.abs(i - start)) {
                    abs = Math.abs(i - start);
                }
            }
        }
        return abs;
    }
}
