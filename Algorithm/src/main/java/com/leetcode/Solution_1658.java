package com.leetcode;

import java.util.Arrays;

public class Solution_1658 {

    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum(), targetInWin = sum - x;
        if (targetInWin <= 0) return targetInWin == 0 ? nums.length : -1;
        int l = 0, r = 0, winLength = Integer.MIN_VALUE, winSum = 0;
        while (r <= nums.length) {
            while (winSum >= targetInWin) {
                if (winSum == targetInWin) winLength = Math.max(winLength, r - l);
                winSum -= nums[l++];
            }
            if (r < nums.length) winSum += nums[r];
            r++;
        }
        return winLength == Integer.MIN_VALUE ? -1 : nums.length - winLength;
    }
}
