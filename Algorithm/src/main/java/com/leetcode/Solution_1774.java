package com.leetcode;

public class Solution_1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            int sub = dp(baseCosts[i], toppingCosts, target);
            if (sub == target) return sub;
            ans = get(sub, ans, target);
        }
        return ans;
    }

    private int dp(int baseCost, int[] toppingCosts, int target) {
        if (baseCost >= target) return baseCost;
        int[] dp = new int[4];
        dp[0] = baseCost;
        dp[1] = baseCost;
        dp[2] = baseCost;
        dp[3] = baseCost;
        for (int i = 0; i < toppingCosts.length; i++) {
            int t1 = dp[0], t2 = dp[1], t3 = dp[2], t4 = dp[3];
            dp[0] = toppingCosts[i];
            dp[1] = get(t1, t2, t3, t4, target);
            dp[2] = get(t1 + toppingCosts[i], t2 + toppingCosts[i], t3 + toppingCosts[i], t4 + toppingCosts[i], target);
            dp[3] = get(t1 + toppingCosts[i] * 2, t2 + toppingCosts[i] * 2, t3 + toppingCosts[i] * 2, t4 + toppingCosts[i] * 2, target);
        }
        return get(dp[0], dp[1], dp[2],dp[3], target);
    }

    private int get(int a1, int a2, int a3, int a4, int target) {
        int a5 = get(a1, a2, target);
        int a6 = get(a4, a3, target);
        return get(a5, a6, target);
    }

    private int get(int ans1, int ans2, int target) {
        int abs1 = Math.abs(ans1 - target);
        int abs2 = Math.abs(ans2 - target);
        if (abs1 != abs2) return abs1 < abs2 ? ans1 : ans2;
        return Math.min(ans1, ans2);
    }
}