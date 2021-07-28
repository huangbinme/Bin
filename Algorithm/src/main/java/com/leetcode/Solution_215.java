package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }
}
