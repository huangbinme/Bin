package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        //73, 74, 75, 71, 69, 72, 76, 73
        //0 , 1 , 2 , 3 , 4 , 5,  6,  7
        int[] ans = new int[temperatures.length];
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && deque.peekLast()[0] < temperatures[i]) {
                int[] ints = deque.pollLast();
                ans[ints[1]] = i - ints[1];
            }
            deque.offerLast(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
