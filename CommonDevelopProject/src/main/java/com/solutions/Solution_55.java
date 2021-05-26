package com.solutions;

public class Solution_55 {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
