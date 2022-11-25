package com.leetcode;

public class Solution_693 {
    public boolean hasAlternatingBits(int n) {
        int i = n % 2;
        do {
            n >>= 1;
            int j = n % 2;
            if (i + j != 1) return false;
            i = j;
        } while (n != 0);
        return true;
    }
}
