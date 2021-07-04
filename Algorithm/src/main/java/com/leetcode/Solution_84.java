package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_84 {
    int ans = 0;

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return ans;
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
            int[] cur = deque.pollLast();
            if(!deque.isEmpty()){
                int l = index - cur[1] + cur[1] - deque.peekLast()[1] - 1;
                ans = Math.max(ans, cur[0] * l);
            }
        }
        deque.offerLast(new int[]{height, index});
    }
}
