package com.leetcode;

import java.util.Arrays;

public class Solution_1824 {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[3];
        dp[0] = -1;
        dp[2] = -1;
        for (int i = 1; i < obstacles.length - 1; i++) {
            if (obstacles[i] == 1 && dp[0] != -1) {
                if (obstacles[i - 1] != 2) dp[1] = dp[1] == -1 ? dp[0] + 1 : Math.min(dp[1], dp[0] + 1);
                if (obstacles[i - 1] != 3) dp[2] = dp[2] == -1 ? dp[0] + 1 : Math.min(dp[2], dp[0] + 1);
                dp[0] = -1;
            } else if (obstacles[i] == 2 && dp[1] != -1) {
                if (obstacles[i - 1] != 1) dp[0] = dp[0] == -1 ? dp[1] + 1 : Math.min(dp[0], dp[1] + 1);
                if (obstacles[i - 1] != 3) dp[2] = dp[2] == -1 ? dp[1] + 1 : Math.min(dp[2], dp[1] + 1);
                dp[1] = -1;
            } else if (obstacles[i] == 3 && dp[2] != -1) {
                if (obstacles[i - 1] != 1) dp[0] = dp[0] == -1 ? dp[2] + 1 : Math.min(dp[0], dp[2] + 1);
                if (obstacles[i - 1] != 2) dp[1] = dp[1] == -1 ? dp[2] + 1 : Math.min(dp[1], dp[2] + 1);
                dp[2] = -1;
            }
        }
        return Arrays.stream(dp).filter(a -> a != -1).min().getAsInt();
    }
}
