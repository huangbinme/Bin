package com.leetcode;

public class Solution_367 {
    public boolean isPerfectSquare(int num) {
        long max = Integer.MAX_VALUE;
        for (long i = 0; i * i < max; i++) {
            if (i * i >= num) return i * i == num;
        }
        return false;
    }
}
