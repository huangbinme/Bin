package com.leetcode;

public class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n < 0) n = -n;
        return (lowBit(n) ^ n) == 0;
    }

    private int lowBit(int i) {
        return i & -i;
    }
}
