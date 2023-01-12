package com.leetcode;

public class Solution_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] preSum = new int[cardPoints.length + 1];
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
            preSum[i + 1] = sum;
        }
        int dis = cardPoints.length - k, ans = Integer.MIN_VALUE;
        for (int i = dis - 1; i < cardPoints.length; i++) {
            int sumWin = preSum[i + 1] - preSum[i - dis + 1];
            ans = Math.max(ans, preSum[preSum.length - 1] - sumWin);
        }
        return ans;
    }
}
