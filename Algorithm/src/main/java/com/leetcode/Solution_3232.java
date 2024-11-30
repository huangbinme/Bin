package com.leetcode;

public class Solution_3232 {
    public boolean canAliceWin(int[] nums) {
        int sum = 0, one = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] < 10) one += nums[i];
        }
        return one * 2 != sum;
    }
}
