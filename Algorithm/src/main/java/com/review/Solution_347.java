package com.review;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] * -1));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
