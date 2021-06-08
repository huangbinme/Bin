package com.leetcode;

public class Solution_896 {
    public boolean isMonotonic(int[] nums) {
        boolean up = false, down = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] > nums[i]) up = true;
            if(nums[i+1] < nums[i]) down = true;
            if(up && down) return false;
        }
        return true;
    }
}
