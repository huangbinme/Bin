package com.leetcode;

public class Solution_1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] connect = new int[n][n];
        int[] connectCount = new int[n];
        for (int i = 0; i < roads.length; i++) {
            int s = Math.min(roads[i][0],roads[i][1]), b = Math.max(roads[i][0],roads[i][1]);
            connect[s][b] = 1;
            connectCount[s]++;
            connectCount[b]++;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, connectCount[i] + connectCount[j] + (connect[i][j] == 1 ? -1 : 0));
            }
        }
        return ans;
    }
}
