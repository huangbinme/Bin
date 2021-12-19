package com.leetcode.offer;

public class Solution_44 {
    public int findNthDigit(int n) {
        if (n == 0) return 0;
        long n1 = 1, n2 = 9, count = 1;
        while (!(n <= n1 * n2 && n > (n1 - 1) * (n2 / 10))) {
            count += (n1 * n2);
            n1++;
            n2 *= 10;
        }
        long n3 = n - count;
        long start = (long) Math.pow(10, n1 - 1) + (n3 / n1);
        long end = n3 % n1;
        return String.valueOf(start).charAt((int) end) - '0';
    }
}
