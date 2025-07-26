package com.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.pollLast();
            deque.offerLast(nums[i]);
        }
        ans.add(deque.peekFirst());
        for (int i = k; i < nums.length; i++) {
            int l = nums[i - k], r = nums[i];
            if (deque.peekFirst().equals(l)) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast() < r) deque.pollLast();
            deque.offerLast(r);
            ans.add(deque.peekFirst());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
