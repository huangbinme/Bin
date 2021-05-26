package com.solutions;

public class Solution_69 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        long left = 1;
        long right = x;
        while (left + 1 != right) {
            long mid = getMid(left, right);
            if (left * left <= x && x <= mid * mid) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left * left <= x && x < right * right ? (int) left : (int) right;
    }

    private long getMid(long i, long j) {
        return i + (j - i) / 2;
    }
}
