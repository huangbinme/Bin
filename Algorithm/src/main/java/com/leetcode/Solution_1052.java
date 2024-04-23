package com.leetcode;

public class Solution_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int[] preSum = new int[customers.length + 1];
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
            preSum[i + 1] = preSum[i] + (grumpy[i] == 0 ? 0 : customers[i]);
        }
        int max = 0;
        //change
        for (int i = X; i < preSum.length; i++) {
            max = Math.max(max, preSum[i] - preSum[i - X]);
        }
        return ans + max;
    }
}
