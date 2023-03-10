package com.leetcode;

public class Solution_32 {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, lCount = 0, ans = 0;
        while (r < s.length()) {
            if (lCount < (r - l - lCount)) {
                l = r;
                lCount = 0;
                continue;
            }
            if (s.charAt(r) == '(') lCount++;
            r++;
            if (r - l == lCount * 2) ans = Math.max(ans, r - l);
        }
        l = s.length() - 1;
        r = s.length() - 1;
        lCount = 0;
        while (l >= 0) {
            if (lCount > (r - l - lCount)) {
                r = l;
                lCount = 0;
                continue;
            }
            if (s.charAt(l) == '(') lCount++;
            l--;
            if (r - l == lCount * 2) ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
