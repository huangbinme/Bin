package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekFirst() <= nums2[i]) deque.pollFirst();
            int value = deque.isEmpty() ? -1 : deque.peekFirst();
            map.put(nums2[i], value);
            deque.offerFirst(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
