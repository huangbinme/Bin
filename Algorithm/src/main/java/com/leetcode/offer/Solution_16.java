package com.leetcode.offer;

public class Solution_16 {
    public double myPow(double x, int n) {
        return pow(n < 0 ? 1 / x : x, Math.abs(n));
    }

    private double pow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double d = pow(x, n / 2);
        return d * d * (n % 2 == 0 ? 1 : x);
    }
}
