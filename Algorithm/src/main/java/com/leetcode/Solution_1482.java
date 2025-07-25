package com.leetcode;

public class Solution_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k < 0 || m * k > bloomDay.length) return -1;
        int l = 1, r = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            r = Math.max(r, bloomDay[i]);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean enough = getMinDays(bloomDay, m, k, mid);
            if (enough) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean getMinDays(int[] bloomDay, int m, int k, int day) {
        int maxM = 0, preOpen = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            boolean open = bloomDay[i] <= day;
            if (open) {
                preOpen++;
                if (preOpen == k) {
                    maxM++;
                    preOpen = 0;
                }
            } else {
                preOpen = 0;
            }
        }
        return maxM >= m;
    }
}
