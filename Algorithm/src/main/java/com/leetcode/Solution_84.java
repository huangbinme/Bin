package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_84 {
    int ans = 0;

    public int largestRectangleArea(int[] heights) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[]{0, 0});
        for (int i = 0; i < heights.length; i++) {
            inQueue(deque, heights[i], i + 1);
        }
        inQueue(deque, 0, heights.length + 1);
        return ans;
    }

    private void inQueue(Deque<int[]> deque, int height, int index) {
        while (!deque.isEmpty() && deque.peekLast()[0] >= height) {
            //Calculation when pop element, then we can get border of left and right
            int[] out = deque.pollLast();
            if (!deque.isEmpty()) {
                int left = out[1] - deque.peekLast()[1] - 1;
                int right = index - out[1];
                ans = Math.max(ans, (left + right) * out[0]);
            }
        }
        deque.offerLast(new int[]{height, index});
    }
}
