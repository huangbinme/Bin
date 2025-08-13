package com.review;

public class Solution_69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long n = (long) (mid + 1) * (mid + 1);
            if (n > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
