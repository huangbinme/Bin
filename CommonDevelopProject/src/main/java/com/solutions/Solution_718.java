package com.solutions;

public class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] dp = new int[nums2.length + 1][nums1.length + 1];
        for (int i = 1; i < nums2.length + 1; i++) {
            for (int j = 1; j < nums1.length + 1; j++) {
                dp[i][j] = nums2[i - 1] != nums1[j - 1] ? 0 : dp[i - 1][j - 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
