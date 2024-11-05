package com.leetcode;

public class Solution_LCR_091 {
    public int minCost(int[][] costs) {
        int[] ans = new int[]{0, 0, 0};
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            int a = cost[0] + Math.min(ans[1], ans[2]);
            int b = cost[1] + Math.min(ans[0], ans[2]);
            int c = cost[2] + Math.min(ans[0], ans[1]);
            ans[0] = a;
            ans[1] = b;
            ans[2] = c;
        }
        return Math.min(ans[0], Math.min(ans[1], ans[2]));
    }
}
