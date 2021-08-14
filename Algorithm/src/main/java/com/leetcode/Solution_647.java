package com.leetcode;

public class Solution_647 {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            ans++;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
        }
        return ans;
    }
}
