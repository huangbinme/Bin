package com.leetcode;

import java.util.LinkedList;

public class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        LinkedList<int[]> deque = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            ans = Math.max(ans, h);
            for (int j = 0; j < deque.size(); j++) {
                int l = j != 0 ? (i - deque.get(j)[1] + 1) : (i + 1);
                int newArea = Math.min(deque.get(j)[0], h) * l;
                ans = Math.max(ans, newArea);
            }
            while (!deque.isEmpty() && deque.peekLast()[0] > h) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{h, i});
        }
        return ans;
    }
}
