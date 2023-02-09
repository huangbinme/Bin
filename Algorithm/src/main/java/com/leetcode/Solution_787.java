package com.leetcode;

import java.util.Arrays;

public class Solution_787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE / 2);
        dis[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] cloneDis = dis.clone();
            for (int j = 0; j < flights.length; j++) {
                int[] edge = flights[j];
                dis[edge[1]] = Math.min(dis[edge[1]], cloneDis[edge[0]] + edge[2]);
            }
        }
        return dis[dst] != Integer.MAX_VALUE / 2 ? dis[dst] : -1;
    }

}
