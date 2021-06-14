package com.leetcode;

public class Solution_374 extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = getMid(l, r);
            int check = guess(mid);
            if (check <= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
