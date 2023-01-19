package com.leetcode;

import java.util.*;

public class Solution_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0) + a.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[0]);
            list.add(0);
            queue.offer(list);
        }
        while (ans.size() != k) {
            List<Integer> poll = queue.poll();
            if (poll == null) break;
            if (poll.get(2) + 1 < nums2.length) {
                List<Integer> list = new ArrayList<>();
                list.add(poll.get(0));
                list.add(nums2[poll.get(2) + 1]);
                list.add(poll.get(2) + 1);
                queue.offer(list);
            }
            ans.add(Arrays.asList(poll.get(0), poll.get(1)));
        }
        return ans;
    }
}
