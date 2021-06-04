package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_456 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int largerCount = 0;
            while (!deque.isEmpty() && deque.peekLast() >= nums[i]) {
                if (deque.pollLast() > nums[i]) largerCount++;
            }
            deque.offerLast(nums[i]);
            if (deque.size() > 1 && largerCount > 0) return true;
        }
        return false;
    }
}
