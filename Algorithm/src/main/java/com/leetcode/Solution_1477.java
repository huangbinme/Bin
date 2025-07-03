package com.leetcode;

import java.util.Arrays;

public class Solution_1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int l = 0, r = 0, sum = 0, minInDp = -1, ans = Integer.MAX_VALUE;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        while (r < arr.length) {
            while (sum + arr[r] > target && l < r) {
                sum -= arr[l++];
            }
            while (sum + arr[r] > target && l == r) {
                dp[l] = minInDp;
                l++;
                r++;
                if(l == arr.length) return ans == Integer.MAX_VALUE ? -1 : ans;
            }
            sum += arr[r];
            if (sum == target) {
                if (l - 1 >= 0 && dp[l - 1] > 0) ans = Math.min(ans, r - l + 1 + dp[l - 1]);
                dp[r] = minInDp != -1 ? Math.min(minInDp, r - l + 1) : r - l + 1;
            } else {
                dp[r] = minInDp;
            }
            minInDp = minInDp == -1 ? dp[r] : Math.min(minInDp, dp[r]);
            r++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
