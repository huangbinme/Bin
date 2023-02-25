package com.leetcode;

public class Solution_1274 {
    public int minimumSwap(String s1, String s2) {
        int x = 0, y = 0, ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            boolean diff = s1.charAt(i) != s2.charAt(i);
            x += (diff && s1.charAt(i) == 'x') ? 1 : 0;
            y += (diff && s1.charAt(i) == 'y') ? 1 : 0;
        }
        ans += x / 2;
        ans += y / 2;
        x %= 2;
        y %= 2;
        if ((x == 0 && y == 0) || (x == 1 && y == 1)) return x == 0 ? ans : ans + 2;
        return -1;
    }
}
