package com.leetcode;

public class Solution_260 {
    public int[] singleNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        n = n & (-n);
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & n) == 0) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }
}
