package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_456 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        Integer maxInPop = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxInPop != null && nums[i] < maxInPop) return true;
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                int num = deque.pollLast();
                maxInPop = maxInPop == null ? num : Math.max(maxInPop, num);
            }
            deque.offerLast(nums[i]);
        }
        return false;
    }
}
