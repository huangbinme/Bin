package com.leetcode;

public class Solution_2594 {
    public long repairCars(int[] ranks, int cars) {
        int minRank = ranks[0];
        for (int i = 0; i < ranks.length; i++) {
            minRank = Math.min(minRank, ranks[i]);
        }
        long l = 0, r = (long) minRank * cars * cars;
        while (l < r) {
            long mid = l + (r - l) / 2;
            int carCount = 0;
            for (int rank : ranks) {
                carCount += Math.sqrt((double) mid / rank);
            }
            if (carCount >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
