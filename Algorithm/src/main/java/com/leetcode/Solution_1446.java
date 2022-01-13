package com.leetcode;

public class Solution_1446 {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;
        int l = 0, r = 0, ans = 1;
        while (r < s.length()) {
            if (s.charAt(r) != s.charAt(l)) l = r;
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
