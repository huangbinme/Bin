package com.leetcode;

public class Solution_2924 {
    public int findChampion(int n, int[][] edges) {
        int[] count = new int[n];
        for (int i = 0; i < edges.length; i++) {
            count[edges[i][1]]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                if (ans == Integer.MAX_VALUE) {
                    ans = i;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}
