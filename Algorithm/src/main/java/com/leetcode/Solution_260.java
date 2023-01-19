package com.leetcode;

public class Solution_260 {
    public int[] singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        int lowBit = num & -num;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lowBit) == 0) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];
            }
        }
        return new int[]{ans1, ans2};
    }
}
