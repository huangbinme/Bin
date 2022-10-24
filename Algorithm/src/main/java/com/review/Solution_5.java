package com.review;

public class Solution_5 {
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0, 1};
        for (int i = 0; i < s.length(); i++) {
            int[] ints = longestPalindrome(s, i, i);
            if (ints[1] - ints[0] > ans[1] - ans[0]) {
                ans = ints;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int[] ints = longestPalindrome(s, i, i + 1);
            if (ints[1] - ints[0] > ans[1] - ans[0]) {
                ans = ints;
            }
        }
        return s.substring(ans[0], ans[1]);
    }

    private int[] longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[]{l + 1, r};
    }
}
