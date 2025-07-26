package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int[] left = new int[heights.length], right = new int[heights.length];
        for (int i = 0; i < left.length; i++) {
            while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) deque.pollLast();
            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        deque.clear();
        for (int i = right.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) deque.pollLast();
            if (deque.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i], l = 1 + (i - left[i] - 1) + (right[i] - i - 1);
            int size = h * l;
            ans = Math.max(ans, size);
        }
        return ans;
    }
}
