package com.leetcode;

import java.util.Arrays;

public class Solution_42 {
    public int trap(int[] height) {
        int maxHeight = Arrays.stream(height).max().getAsInt();
        int ans = 0;
        for (int i = 1; i <= maxHeight; i++) {
            int plus = 0, left = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i && left == 0) {
                    left = 1;
                } else if (height[j] >= i && left == 1) {
                    ans += plus;
                    plus = 0;
                } else if (left == 1 && height[j] < i) {
                    plus++;
                }
            }
        }
        return ans;
    }
}
