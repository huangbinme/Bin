package com.solutions;

public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        int costLeft = 0;
        int costRight = 0;
        for (int i = 2; i < cost.length; i++) {
            int tmp = costRight;
            costRight = Math.min(costLeft + cost[i - 2], costRight + cost[i - 1]);
            costLeft = tmp;
        }
        return Math.min(costRight + cost[cost.length - 1], costLeft + cost[cost.length - 2]);
    }
}
