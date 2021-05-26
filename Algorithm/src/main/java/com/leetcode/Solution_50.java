package com.leetcode;

public class Solution_50 {

    public double myPow(double x, int n) {
        if (n == 0) return 1d;
        if (x == 0) return 0;
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1d / pow(x, -n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        double d = pow(x, n / 2);
        return n % 2 != 0 ? d * d * x : d * d;
    }
}
