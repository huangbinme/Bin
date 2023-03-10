package com.leetcode;

public class Solution_2379 {
    public int minimumRecolors(String blocks, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) != 'B') {
                ans++;
            }
        }
        int win = ans;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') win++;
            if (blocks.charAt(i - k) == 'W') win--;
            ans = Math.min(win, ans);
        }
        return ans;
    }
}
