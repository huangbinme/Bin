package com.leetcode;

public class Solution_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] + nums[i - 1]) % 2 != 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (dp[queries[i][1]] - dp[queries[i][0]] == queries[i][1] - queries[i][0]) {
                ans[i] = true;
            }
        }
        return ans;
    }
}
