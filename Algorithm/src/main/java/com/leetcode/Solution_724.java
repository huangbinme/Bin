package com.leetcode;

public class Solution_724 {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i - 1] == preSum[preSum.length - 1] - preSum[i]) return i - 1;
        }
        return -1;
    }
}
