package com.solutions;

public class Solution_62 {
    public int uniquePaths(int m, int n) {
        return calPath(m,n);
    }

    public int calPath(int m, int n){
        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    array[i][j] = 1;
                    continue;
                }
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }

        return array[m-1][n-1];
    }
}
