package com.solutions;

public class Solution_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int r = 0, l = 0, ans = 0;
        while (r < s.length()) {
            int rCost = Math.abs(t.charAt(r) - s.charAt(r));
            while (maxCost - rCost < 0 && l < r) {
                maxCost += Math.abs(t.charAt(l) - s.charAt(l));
                l++;
            }
            maxCost -= rCost;
            r++;
            if (maxCost >= 0) ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
