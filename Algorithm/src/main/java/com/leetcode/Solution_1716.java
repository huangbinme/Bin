package com.leetcode;

public class Solution_1716 {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int a = nums[0];
        int b = 0;

        for (int i = 1; i < nums.length; i++) {
            int tmp_a = a;
            a = b + nums[i];
            b = Math.max(tmp_a, b);
        }

        return Math.max(a, b);
    }
}
