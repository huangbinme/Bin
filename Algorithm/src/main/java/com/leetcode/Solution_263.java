package com.leetcode;

public class Solution_263 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        int num = n;
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 5;
        }
        while (num % 2 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
