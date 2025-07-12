package com.review;

public class Solution_42 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, ans = 0, lMax = 0, rMax = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (rMax > lMax) {
                ans += (lMax - height[l]);
                l++;
            } else {
                ans += (rMax - height[r]);
                r--;
            }
        }
        return ans;
    }
}
