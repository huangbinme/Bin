package com.leetcode;

public class Solution_1752 {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = (i + 1) % nums.length;
            if (nums[i] <= nums[next]) count++;
        }
        return count == nums.length - 1;
    }
}
