package com.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = deque.peekFirst();
        for (int i = 0; i < ans.length - 1; i++) {
            if (deque.peekFirst() == nums[i]) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i + k]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i + k]);
            ans[i + 1] = deque.peekFirst();
        }
        return ans;
    }
}
