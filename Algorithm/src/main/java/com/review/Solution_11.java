package com.review;

public class Solution_11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ans = Integer.MIN_VALUE;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
