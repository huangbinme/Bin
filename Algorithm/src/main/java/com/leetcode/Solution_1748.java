package com.leetcode;

public class Solution_1748 {
    public int sumOfUnique(int[] nums) {
        int[] showCount = new int[100];
        for (int i = 0; i < nums.length; i++) {
            showCount[nums[i] - 1]++;
        }
        int ans = 0;
        for (int i = 0; i < showCount.length; i++) {
            if (showCount[i] == 1) ans += (i + 1);
        }
        return ans;
    }
}
