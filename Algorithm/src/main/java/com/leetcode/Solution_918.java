package com.leetcode;

public class Solution_918 {
    public int maxSubarraySumCircular(int[] A) {
        int[] preSum = new int[A.length + 1];
        int sum = 0;
        boolean allNegative = true;
        for (int i = 1; i < preSum.length; i++) {
            sum += A[i - 1];
            preSum[i] = sum;
            if (A[i - 1] >= 0) allNegative = false;
        }
        int preMin = 0, max = Integer.MIN_VALUE, preMax = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            max = Math.max(max, preSum[i] - preMin);
            preMin = Math.min(preMin, preSum[i]);
            min = Math.min(min, preSum[i] - preMax);
            preMax = Math.max(preMax, preSum[i]);
        }
        return allNegative ? max : Math.max(max, preSum[preSum.length - 1] - min);
    }
}
