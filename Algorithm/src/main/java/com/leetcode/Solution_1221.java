package com.leetcode;

public class Solution_1221 {
    public int balancedStringSplit(String s) {
        int p = 0, ans = 0, count = 0;
        while (p < s.length()) {
            count += (s.charAt(p++) == 'R') ? 1 : -1;
            if (count == 0) ans++;
        }
        return ans;
    }
}
