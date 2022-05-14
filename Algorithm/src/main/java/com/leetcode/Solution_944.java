package com.leetcode;

public class Solution_944 {
    public int minDeletionSize(String[] strs) {
        int x = strs[0].length(), y = strs.length, ans = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
