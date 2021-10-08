package com.leetcode;

public class Solution_434 {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i < s.length() - 1 && s.charAt(i) != ' ' && s.charAt(i + 1) == ' ') || (i == s.length() - 1 && s.charAt(i) != ' ')) {
                ans++;
            }
        }
        return ans;
    }
}
