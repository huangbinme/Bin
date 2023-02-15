package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1124 {
    public int longestWPI(int[] hours) {
        int[] preSum = new int[hours.length + 1];
        int sum = 0;
        for (int i = 1; i < preSum.length; i++) {
            sum += hours[i - 1] > 8 ? 1 : -1;
            preSum[i] = sum;
        }
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < preSum.length; i++) {
            if (deque.isEmpty() || deque.peekLast()[0] > preSum[i]) {
                deque.offerLast(new int[]{preSum[i], i});
            }
        }
        int ans = 0;
        for (int i = preSum.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekLast()[0] < preSum[i]) {
                ans = Math.max(ans, i - deque.pollLast()[1]);
            }
        }
        return ans;
    }
}
