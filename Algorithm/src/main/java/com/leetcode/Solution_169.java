package com.leetcode;

public class Solution_169 {
    public int majorityElement(int[] nums) {
        int c = 1, n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (c == 0) {
                n = nums[i];
                c++;
            } else {
                if (n == nums[i]) {
                    c++;
                } else {
                    c--;
                }
            }
        }
        return n;
    }
}
