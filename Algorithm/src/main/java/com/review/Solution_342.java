package com.review;

public class Solution_342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int j = 0, num = 0;
        while (num < n) {
            num = pow(4, j++);
            if (num < 0) return false;
        }
        return num == n;
    }

    private int pow(int i, int j) {
        if (j == 0) return 1;
        if (j == 1) return i;
        int k = pow(i, j / 2);
        k *= k;
        if (j % 2 == 1) {
            k *= i;
        }
        return k;
    }
}
