package com.leetcode;

public class Solution_997 {
    public int findJudge(int n, int[][] trust) {
        int[] record = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            record[trust[i][1]]++;
            record[trust[i][0]]--;
        }
        for (int i = 1; i < record.length; i++) {
            if (record[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
