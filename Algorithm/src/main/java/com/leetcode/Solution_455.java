package com.leetcode;

import java.util.Arrays;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, gIndex = 0, sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                ans++;
                sIndex++;
                gIndex++;
            } else {
                sIndex++;
            }
        }
        return ans;
    }
}
