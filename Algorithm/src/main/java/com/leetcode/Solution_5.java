package com.leetcode;

public class Solution_5 {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String sub1 = longestPalindrome(s, i, i);
            ans = sub1.length() > ans.length() ? sub1 : ans;
            if (i != s.length() - 1) {
                String sub2 = longestPalindrome(s, i, i + 1);
                ans = sub2.length() > ans.length() ? sub2 : ans;
            }
        }
        return ans;
    }

    public String longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }
}
