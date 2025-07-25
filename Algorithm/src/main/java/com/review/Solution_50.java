package com.review;

public class Solution_50 {
    public double myPow(double x, int n) {
        double ans = quickPow(x, Math.abs(n));
        return n < 0 ? 1 / ans : ans;
    }

    private double quickPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        double y = quickPow(x, n / 2);
        return y * y * (n % 2 == 0 ? 1 : x);
    }
}
