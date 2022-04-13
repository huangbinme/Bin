package com.leetcode;

public class Solution_1952 {
    public boolean isThree(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (count > 3) return false;
            if (n % i == 0) {
                count++;
            }
        }
        return count == 3;
    }
}
