package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_2293 {
    public int minMaxGame(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            deque.offerLast(nums[i]);
        }
        boolean isMinOps = true;
        while (deque.size() != 1) {
            int i = deque.pollFirst(), j = deque.pollFirst();
            if (isMinOps) {
                deque.offerLast(Math.min(i, j));
            } else {
                deque.offerLast(Math.max(i, j));
            }
            isMinOps = !isMinOps;
        }
        return deque.pollFirst();
    }
}
