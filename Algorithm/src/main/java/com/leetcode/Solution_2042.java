package com.leetcode;

public class Solution_2042 {
    public boolean areNumbersAscending(String s) {
        int pre = -1;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (s.charAt(r) - '0' >= 0 && s.charAt(r) - '0' <= 9) {
                l = r;
                while (r < s.length() && s.charAt(r) - '0' >= 0 && s.charAt(r) - '0' <= 9) r++;
                int cur = Integer.parseInt(s.substring(l, r));
                if (pre >= cur) return false;
                pre = cur;
                r++;
                l = r;
            } else {
                r++;
            }
        }
        return true;
    }
}
