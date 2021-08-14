package com.leetcode;

public class Solution_5 {
    public String longestPalindrome(String s) {
        String ans = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > ans.length()) {
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > ans.length()) {
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
