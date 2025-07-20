package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<int[]> deque = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekFirst()[0] <= temperatures[i]) deque.pollFirst();
            if (!deque.isEmpty()) {
                ans[i] = deque.peekFirst()[1] - i;
            } else {
                ans[i] = 0;
            }
            deque.offerFirst(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
