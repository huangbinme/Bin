package com.review;

public class Solution_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE, r = 0;
        for (int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            int d = getDays(weights, mid);
            if (d <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int getDays(int[] weights, int max) {
        int days = 0, cur = 0;
        for (int i = 0; i < weights.length; i++) {
            if (cur + weights[i] <= max) {
                cur += weights[i];
            } else {
                days++;
                cur = weights[i];
            }
        }
        return days + 1;
    }
}
