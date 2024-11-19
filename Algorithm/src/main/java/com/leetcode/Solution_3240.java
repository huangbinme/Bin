package com.leetcode;

public class Solution_3240 {
    public int minFlips(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
        if (m > 1 && n > 1) {
            for (int i = 0; i < m / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int oneCount = grid[i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][j] + grid[m - 1 - i][n - 1 - j];
                    ans += (Math.min(oneCount, 4 - oneCount));
                }
            }
        }
        int onePair = 0, diffPair = 0;
        if (m % 2 != 0) {
            int a = 0, b = n - 1;
            while (a < b) {
                if (grid[m / 2][a] == 1 && grid[m / 2][b] == 1) onePair++;
                if (grid[m / 2][a] != grid[m / 2][b]) diffPair++;
                a++;
                b--;
            }
        }
        if (n % 2 != 0) {
            int a = 0, b = m - 1;
            while (a < b) {
                if (grid[a][n / 2] == 1 && grid[b][n / 2] == 1) onePair++;
                if (grid[a][n / 2] != grid[b][n / 2]) diffPair++;
                a++;
                b--;
            }
        }
        ans += cal(onePair, diffPair);
        if (m == 1 && n % 2 != 0) ans += grid[0][n / 2];
        if (m % 2 != 0 && n == 1) ans += grid[m / 2][0];
        if (m > 1 && n > 1 && m % 2 != 0 && n % 2 != 0) ans += grid[m / 2][n / 2];
        return ans;
    }

    private int cal(int onePair, int diffPair) {
        if (((onePair * 2) % 4 == 0) || ((onePair * 2) % 4 != 0 && diffPair > 0)) {
            return diffPair;
        } else {
            return 2;
        }
    }
}
