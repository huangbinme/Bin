package com.leetcode;

public class Solution_3001 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && !(c == a && d < Math.max(b, f) && d > Math.min(b, f))) return 1;
        if (b == f && !(d == b && c < Math.max(a, e) && c> Math.min(a, e))) return 1;
        if (Math.abs(c - e) == Math.abs(d - f) && ((d - b) * (e - c) != (c - a) * (f - d) || (a > Math.max(c, e) || a < Math.min(c, e)))) return 1;
        return 2;
    }
}
