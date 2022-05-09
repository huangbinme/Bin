package com.leetcode;

public class Solution_942 {
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length() + 1];
        int min = 0, max = s.length();
        for (int i = 0; i < ans.length - 1; i++) {
            if (s.charAt(i) == 'D') {
                ans[i] = max--;
            } else {
                ans[i] = min++;
            }
        }
        ans[ans.length - 1] = max;
        return ans;
    }
}
