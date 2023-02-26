package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_42 {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = height.length - 1; i >= 2; i--) {
            if (deque.isEmpty() || height[i] >= deque.peekFirst()) {
                deque.offerFirst(height[i]);
            }
        }
        int ans = 0, lMax = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            int rMax = deque.peekFirst();
            if (lMax > height[i] && rMax > height[i]) {
                ans += Math.min(lMax, rMax) - height[i];
            }
            if (i != 1 && deque.peekFirst() == height[i]) deque.pollFirst();
            lMax = Math.max(lMax, height[i]);
        }
        return ans;
    }
}
