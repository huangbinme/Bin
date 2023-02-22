package com.leetcode;

import java.util.Arrays;

public class Solution_1049 {


    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2    ;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j - stones[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - dp[dp.length - 1] * 2;
    }

}
