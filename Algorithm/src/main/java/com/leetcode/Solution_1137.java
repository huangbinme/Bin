package com.leetcode;

public class Solution_1137 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 0; i < n - 2; i++) {
            int newC = a + b + c;
            a = b;
            b = c;
            c = newC;
        }
        return c;
    }
}
