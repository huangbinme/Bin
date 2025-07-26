package com.review;

import java.util.Deque;
import java.util.LinkedList;

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

    public int trap2(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < height[i]) deque.pollLast();
            deque.offerLast(height[i]);
        }
        int ans = 0, leftMax = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (deque.peekFirst().equals(height[i])) deque.pollFirst();
            int rightMax = deque.peekFirst();
            if (leftMax > height[i] && rightMax > height[i]) {
                ans += (Math.min(leftMax, rightMax) - height[i]);
            }
            leftMax = Math.max(leftMax, height[i]);
        }
        return ans;
    }
}
