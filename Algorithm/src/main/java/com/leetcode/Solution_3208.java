package com.leetcode;

public class Solution_3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0, l = 0, r = 0;
        while (r < colors.length + k) {
            if (r != l && r > 0 && colors[r % colors.length] == colors[(r - 1) % colors.length]) {
                l = r;
                continue;
            }
            r++;
            if (r - l >= k && r != (colors.length + k)) ans++;
        }
        return ans;
    }
}
