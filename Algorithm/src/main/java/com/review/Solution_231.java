package com.review;

public class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int one = 0;
        while (n != 0) {
            one += (n % 2);
            n >>= 1;
        }
        return one == 1;
    }
}
