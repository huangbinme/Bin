package com.leetcode;

public class Solution_342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (Integer.parseInt("10101010101010101010101010101010", 2) & n) == 0;
    }
}
