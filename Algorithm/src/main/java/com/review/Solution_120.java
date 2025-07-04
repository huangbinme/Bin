package com.review;

import java.util.List;

public class Solution_120 {

    int ans = Integer.MAX_VALUE;

    int[][] stat = new int[200][200];

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j <= i; j++) {
                stat[i][j] = Integer.MAX_VALUE;
            }
        }
        dfs(triangle, 0, 0, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> triangle, int x, int y, int sum) {
        if (x == triangle.size() - 1) {
            ans = Math.min(ans, sum + triangle.get(x).get(y));
            return;
        }
        sum += triangle.get(x).get(y);
        if (stat[x][y] > sum) {
            stat[x][y] = sum;
            dfs(triangle, x + 1, y, sum);
            dfs(triangle, x + 1, y + 1, sum);
        }
    }
}
