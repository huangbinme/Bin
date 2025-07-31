package com.review;

public class Solution_400 {
    public int findNthDigit(int n) {
        //1 - 9 -> 9 * 1
        //10 - 99 -> 90 * 2 = 270
        //100 - 999 -> 900 * 3 = 2700
        //1000 - 9999 -> 9000 * 4 = 27000
        long i = 1, j = 9, m = n, digits = 1;
        while ((j - i + 1) * digits < n) {
            m -= ((j - i + 1) * digits);
            i *= 10;
            j *= 10;
            j += 9;
            digits++;
        }
        long num = i + (m % digits == 0 ? m / digits - 1 : m / digits);
        long index = (m - 1) % digits;
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return sb.charAt((int) index) - '0';
    }
}
