package com.leetcode.offer;

public class Solution_13 {
    int ans = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] ifArrive = new boolean[m][n];
        dfs(ifArrive, k, 0, 0);
        return ans;
    }

    private void dfs(boolean[][] ifArrive, int k, int i, int j) {
        if (!inBound(ifArrive, i, j) || !validate(i, j, k) || ifArrive[i][j]) return;
        if (!ifArrive[i][j]) {
            ans++;
            ifArrive[i][j] = true;
        }
        dfs(ifArrive, k, i - 1, j);
        dfs(ifArrive, k, i + 1, j);
        dfs(ifArrive, k, i, j - 1);
        dfs(ifArrive, k, i, j + 1);
    }

    private boolean inBound(boolean[][] ifArrive, int i, int j) {
        return i >= 0 && i < ifArrive.length && j >= 0 && j < ifArrive[0].length;
    }

    private boolean validate(int i, int j, int k) {
        return cal(i) + cal(j) <= k;
    }

    private int cal(int i) {
        int iCount = 0;
        while (i != 0) {
            iCount += (i % 10);
            i /= 10;
        }
        return iCount;
    }
}
