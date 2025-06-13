package com.review;

public class Solution_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long reverse = 0, longX = x, copyLongX = x;
        while (longX != 0) {
            reverse *= 10;
            reverse += (longX % 10);
            longX /= 10;
        }
        return reverse == copyLongX;
    }
}
