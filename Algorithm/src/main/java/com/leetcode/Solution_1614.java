package com.leetcode;

public class Solution_1614 {
    public int maxDepth(String s) {
        int ans = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                ans = Math.max(ans, count);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return ans;
    }
}
