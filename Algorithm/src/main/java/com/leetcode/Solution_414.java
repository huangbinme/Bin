package com.leetcode;

public class Solution_414 {
    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > c) {
                a = b;
                b = c;
                c = nums[i];
            } else if (nums[i] < c && nums[i] > b) {
                a = b;
                b = nums[i];
            } else if (nums[i] < b && nums[i] > a) {
                a = nums[i];
            }
        }
        return a == Long.MIN_VALUE ? (int) c : (int) a;
    }
}
