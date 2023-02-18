package com.leetcode;

public class Solution_2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                ans[0] += count[i] / 2;
                ans[1] += count[i] % 2;
            }
        }
        return ans;
    }
}
